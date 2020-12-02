package org.SEP4_Data.android_endpoint.measurement;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.MeasurementService;
<<<<<<< HEAD
import org.SEP4_Data.service.model.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

=======
import org.SEP4_Data.service.model.dw.DDateEntity;
import org.SEP4_Data.service.model.dw.DDeviceEntity;
import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.DTimeEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


>>>>>>> second_database_datasource
@RestController
@RequiredArgsConstructor
public class MeasurementController {

    @NonNull
    private MeasurementService service;

    @GetMapping("/current")
<<<<<<< HEAD
    public Data getMeasurement(){
=======
>>>>>>> second_database_datasource

    public MeasurementControllerDTO getMeasurement(){

<<<<<<< HEAD
        Data currentM = service.getCurrentMeasurements();
=======
>>>>>>> second_database_datasource

        DMeasurementsEntity currentM = service.getCurrentMeasurements();
        DDateEntity dateEntity = service.getDateById(currentM.getId().getD_date_Id());
        DDeviceEntity deviceEntity = service.getDeviceById(currentM.getId().getD_device_Id());
        DTimeEntity timeEntity = service.getTimeById(currentM.getId().getD_time_Id());

        MeasurementControllerDTO measurementDTO = new MeasurementControllerDTO(currentM.getTemperature(),currentM.getHumidity(),currentM.getCo2(),currentM.getLight(), deviceEntity.getDeviceId(),dateEntity.getDate(),timeEntity.getTime());
        //  MeasurementControllerDTO measurementDTO = new MeasurementControllerDTO(currentM.getTemperature(),currentM.getHumidity(),currentM.getCo2(),currentM.getLight());

        return measurementDTO;
    }
}