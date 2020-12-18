package org.SEP4_Data.iot_gateway_endpoint;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@RequiredArgsConstructor
@Getter
@Setter
public class MeasurementDTO {
    private double temperature;
    private boolean light;
    private double humidity;
    private int co2;

}


