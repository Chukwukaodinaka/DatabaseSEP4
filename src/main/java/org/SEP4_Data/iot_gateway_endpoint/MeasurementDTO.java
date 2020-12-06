package org.SEP4_Data.iot_gateway_endpoint;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@RequiredArgsConstructor
@Getter
@Setter
public class MeasurementDTO {
    private int temperature;
    private boolean light;
    private int humidity;
    private int co2;

}


