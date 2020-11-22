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

    // note - dto made based on DW-ER since there is no SourceDB-ER uploaded

    private int id;
    private int id_device;
    private LocalDate date;
    private LocalTime time;
    private int temperature;
    private boolean light;
    private int humidity;
    private int co2;

}


