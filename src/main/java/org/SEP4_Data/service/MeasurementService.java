package org.SEP4_Data.service;

<<<<<<< HEAD
import org.SEP4_Data.service.model.Data;
import org.SEP4_Data.service.repository.MeasurementRepo;
=======
import org.SEP4_Data.service.model.dw.DDateEntity;
import org.SEP4_Data.service.model.dw.DDeviceEntity;
import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.DTimeEntity;
import org.SEP4_Data.service.repository.dw.DateRepo;
import org.SEP4_Data.service.repository.dw.DeviceRepo;
import org.SEP4_Data.service.repository.dw.MeasurementRepo;
import org.SEP4_Data.service.repository.dw.TimeRepo;
>>>>>>> second_database_datasource
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo repository;

<<<<<<< HEAD
    public Data getCurrentMeasurements(){
        Data current = repository.findTopByOrderByIdDesc();
=======
    @Autowired
    private DeviceRepo deviceRepo;

    @Autowired
    private DateRepo dateRepo;

    @Autowired
    private TimeRepo timeRepo;


    public DMeasurementsEntity getCurrentMeasurements(){
        DMeasurementsEntity current = repository.findTopByOrderByIdDesc();
>>>>>>> second_database_datasource

        return current;
    }

    public DDeviceEntity getDeviceById(Integer id){
        DDeviceEntity deviceEntity = deviceRepo.findDDateEntityByDDateId(id);
        return deviceEntity;
    }
    public DDateEntity getDateById(Integer id){
        DDateEntity dateEntity = dateRepo.findDDateEntityByDDateId(id);
        return dateEntity;
    }
    public DTimeEntity getTimeById(Integer id){
        DTimeEntity timeEntity = timeRepo.findDDateEntityByDDateId(id);
        return timeEntity;
    }


}
