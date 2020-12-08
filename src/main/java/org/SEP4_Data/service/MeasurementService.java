package org.SEP4_Data.service;

import org.SEP4_Data.service.model.dataWarehouse.Dw_FMeasurementsEntity;
import org.SEP4_Data.service.repository.dw.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo repository;


    public Dw_FMeasurementsEntity getCurrentMeasurements(String location){
        List<Dw_FMeasurementsEntity> current = repository.findCurrentByLocation(location, PageRequest.of(0,1));
        return current.get(0);
    }

}
