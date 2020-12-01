package com.example.demo.service;

import com.example.demo.OneService;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<OneService> getServiceList() {
        return serviceRepository.serviceList();
    }

    public void deleteService(OneService oneService) {
        serviceRepository.updateServiceStatus(oneService);
    }


}
