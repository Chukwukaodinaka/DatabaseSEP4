package org.SEP4_Data.android_endpoint.measurement;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.iot_gateway_endpoint.MeasurementDTO;
import org.SEP4_Data.service.MeasurementService;
import org.SEP4_Data.service.model.Measurements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequiredArgsConstructor
public class MeasurementController {

    @NonNull
    private MeasurementService service;

    @GetMapping("/current")
    public Measurements getMeasurement(){


        Measurements currentM = service.getCurrentMeasurements();

        return currentM;
    }
}
/**8080 port*/