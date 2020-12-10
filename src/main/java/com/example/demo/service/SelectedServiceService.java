package com.example.demo.service;

import com.example.demo.NameForSelectedServiceWeb;
import com.example.demo.SelectedService;
import com.example.demo.VehicleSelectedServiceDashboard;
import com.example.demo.repository.SelectedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

@Service
public class SelectedServiceService {

    @Autowired
    private SelectedServiceRepository selectedServiceRepository;

    public List<com.example.demo.SelectedService> getSelectedService(BigInteger vehicleId){
        return selectedServiceRepository.getSelectedService(vehicleId);
    }

    public List<com.example.demo.SelectedService> getVehicleServiceList(BigInteger vehicleId){
        return selectedServiceRepository.getVehicleServiceList(vehicleId);
    }
    public List<NameForSelectedServiceWeb> getVehicleServiceListWithServiceName(BigInteger vehicleId){
        return selectedServiceRepository.getVehicleServiceListWithServiceName(vehicleId);
    }

    public void updateSelectedService(List<SelectedService> selectedServiceList){
       for (SelectedService ss: selectedServiceList ) {
           if (ss.isActive()) {
               selectedServiceRepository.updateSelectedService(ss);
           }
       }
    }

    public List<VehicleSelectedServiceDashboard> getServicesToDashboard(BigInteger vehicleId){

        List<VehicleSelectedServiceDashboard> vssdList = selectedServiceRepository.getServicesToDashboard(vehicleId);
        for (VehicleSelectedServiceDashboard vssd: vssdList
             ) {

            if (vssd.getpUnit().equals("km")){
                vssd.setNextSOdo(vssd.getLastSOdo().add(vssd.getpValue()));
            }
                if (vssd.getpUnit().equals("aasta") && vssd.getLastSDate() != null){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(vssd.getLastSDate());
                    BigInteger addYear = vssd.getpValue();
                    calendar.add(Calendar.YEAR,addYear.intValue());
                    vssd.setNextSDate(calendar.getTime());
                }
            if (vssd.getLastSDate() == null){
                vssd.setComment(vssd.getiComment());
            }
        }
        return vssdList;
    }
}
