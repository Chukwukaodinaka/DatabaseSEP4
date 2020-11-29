package org.SEP4_Data.android_endpoint.measurement;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.MeasurementService;
import org.SEP4_Data.service.model.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MeasurementController {

    @NonNull
    private MeasurementService service;

    @GetMapping("/current")
    public Data getMeasurement(){


        Data currentM = service.getCurrentMeasurements();

        return currentM;
    }
}