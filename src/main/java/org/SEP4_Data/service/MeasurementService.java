package org.SEP4_Data.service;

import org.SEP4_Data.service.model.dw.DDateEntity;
import org.SEP4_Data.service.model.dw.DDeviceEntity;
import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.DTimeEntity;
import org.SEP4_Data.service.repository.dw.DateRepo;
import org.SEP4_Data.service.repository.dw.DeviceRepo;
import org.SEP4_Data.service.repository.dw.MeasurementRepo;
import org.SEP4_Data.service.repository.dw.TimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo repository;


    public DMeasurementsEntity getCurrentMeasurements(String location){
        DMeasurementsEntity current = repository.findCurrentByLocation(location);
        return current;
    }

}
