package org.SEP4_Data.service;

import org.SEP4_Data.service.model.dataWarehouse.Dw_FMeasurementsEntity;
import org.SEP4_Data.service.repository.dw.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo repository;


    public Dw_FMeasurementsEntity getCurrentMeasurements(String location){
        List<Dw_FMeasurementsEntity> current = repository.findCurrentByLocation(location, PageRequest.of(0,1));
        try{
            return current.get(0);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Nothing in database");
            return new Dw_FMeasurementsEntity();
        }
    }

    public List<Float> getTempHistory(String location, LocalDate from, LocalDate to)
    {
        List<Float> tempHistory = repository.getTempHistory(location, Date.valueOf(from),Date.valueOf(to));
        return tempHistory;
    }

    public List<Float> getCo2History(String location, LocalDate from, LocalDate to)
    {
        List<Float> tempHistory = repository.getCo2History(location,Date.valueOf(from),Date.valueOf(to));
        return tempHistory;
    }

    public List<Float> getHumidityHistory(String location, LocalDate from, LocalDate to)
    {
        List<Float> tempHistory = repository.getHumidityHistory(location,Date.valueOf(from),Date.valueOf(to));
        return tempHistory;
    }

    public List<Boolean> getLightHistory(String location, LocalDate from, LocalDate to)
    {
        List<Boolean> tempHistory = repository.getLightHistory(location,Date.valueOf(from),Date.valueOf(to));
        return tempHistory;
    }

}
