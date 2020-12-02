package org.SEP4_Data.android_endpoint.measurement;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.MeasurementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.SEP4_Data.service.model.dw.DDateEntity;
import org.SEP4_Data.service.model.dw.DDeviceEntity;
import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.DTimeEntity;


@RestController
@RequiredArgsConstructor
public class MeasurementController {

    @NonNull
    private MeasurementService service;

    @GetMapping("/current")
    public CurrentMeasurementsDTO getMeasurement(){

        DMeasurementsEntity currentM = service.getCurrentMeasurements();
        DDateEntity dateEntity = service.getDateById(currentM.getId().getD_date_Id());
        DDeviceEntity deviceEntity = service.getDeviceById(currentM.getId().getD_device_Id());
        DTimeEntity timeEntity = service.getTimeById(currentM.getId().getD_time_Id());

        CurrentMeasurementsDTO measurementDTO = new CurrentMeasurementsDTO(currentM.getTemperature(),currentM.getHumidity(),currentM.getCo2(),currentM.getLight(),
                deviceEntity.getDeviceId(), deviceEntity.getLocation(),
                dateEntity.getDate(),timeEntity.getTime());

        return measurementDTO;
    }
}