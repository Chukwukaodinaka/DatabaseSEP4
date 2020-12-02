package org.SEP4_Data.android_endpoint.measurement;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.iot_gateway_endpoint.MeasurementDTO;
import org.SEP4_Data.service.MeasurementService;
import org.SEP4_Data.service.model.source.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.SEP4_Data.service.model.dw.DDateEntity;
import org.SEP4_Data.service.model.dw.DDeviceEntity;
import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.DTimeEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MeasurementController {

    @NonNull
    private MeasurementService service;

    @GetMapping("/current")
    public MeasurementControllerDTO getMeasurement(){

        DMeasurementsEntity currentM = service.getCurrentMeasurements();
        DDateEntity dateEntity = service.getDateById(currentM.getId().getD_date_Id());
        DDeviceEntity deviceEntity = service.getDeviceById(currentM.getId().getD_device_Id());
        DTimeEntity timeEntity = service.getTimeById(currentM.getId().getD_time_Id());

        MeasurementControllerDTO measurementDTO = new MeasurementControllerDTO(currentM.getTemperature(),currentM.getHumidity(),currentM.getCo2(),currentM.getLight(), deviceEntity.getDeviceId(),dateEntity.getDate(),timeEntity.getTime());
        //  MeasurementControllerDTO measurementDTO = new MeasurementControllerDTO(currentM.getTemperature(),currentM.getHumidity(),currentM.getCo2(),currentM.getLight());

        return measurementDTO;
    }
}