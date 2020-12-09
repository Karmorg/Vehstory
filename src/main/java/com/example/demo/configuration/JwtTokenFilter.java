package com.example.demo.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.catalina.LifecycleState;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class JwtTokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = resolveToken((HttpServletRequest) request);
        if (token != null){
            Authentication authentication = validateToken(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private Authentication validateToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
        List<GrantedAuthority>grantedAuthorityList = new ArrayList<GrantedAuthority>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetails = new MyUser((String) claims.get("name"),"",(BigInteger) claims.get("clientId"), grantedAuthorityList);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String resolveToken(HttpServletRequest request) {
        String headerAttribute = request.getHeader("Authorization");
        if (headerAttribute == null){
            return null;
        }
        if (headerAttribute.startsWith("Bearer")){
            return headerAttribute.substring(7);
        }
        return headerAttribute;
    }
}
