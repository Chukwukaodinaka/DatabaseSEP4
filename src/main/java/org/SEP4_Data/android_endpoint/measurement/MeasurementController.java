package org.SEP4_Data.android_endpoint.measurement;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.MeasurementService;
import org.SEP4_Data.service.model.Measurements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MeasurementController {

    @NonNull
    private MeasurementService service;

    @GetMapping("/current")
    public Measurements getMeasurement(){/*
        MeasurementDTO currentM= new MeasurementDTO();
        currentM.setId(1);
        currentM.setId_device(001);
        currentM.setDate(LocalDate.of(2020, 05,01));
        currentM.setTime(LocalTime.of(7,15));
        currentM.setLight(true);
        currentM.setTemperature(28);
        currentM.setHumidity(100);
        currentM.setCo2(67);*/

        Measurements currentM = service.getCurrentMeasurements();

        return currentM;
    }
}
