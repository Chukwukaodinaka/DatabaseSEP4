package org.SEP4_Data.service;

import org.SEP4_Data.service.model.Data;
import org.SEP4_Data.service.repository.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo repository;

    public Data getCurrentMeasurements(){
        Data current = repository.findTopByOrderByIdDesc();

        return current;
    }

}
