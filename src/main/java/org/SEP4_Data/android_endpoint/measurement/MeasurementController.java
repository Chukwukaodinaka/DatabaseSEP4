package org.SEP4_Data.android_endpoint.measurement;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.MeasurementService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.SEP4_Data.service.model.dataWarehouse.Dw_FMeasurementsEntity;

@RestController
@RequiredArgsConstructor
public class MeasurementController {

    @NonNull
    private MeasurementService service;

    @GetMapping("/current")
    public CurrentMeasurementsDTO getMeasurement(@RequestParam String location){

         Dw_FMeasurementsEntity currentM = service.getCurrentMeasurements(location);

        double temperature = currentM.getTemperature();
        double humidity = currentM.getHumidity();
        int co2 = currentM.getCo2();
        boolean light = currentM.isLight();

        CurrentMeasurementsDTO measurementDTO = new CurrentMeasurementsDTO(temperature, humidity, co2, light);

        return measurementDTO;
    }
}