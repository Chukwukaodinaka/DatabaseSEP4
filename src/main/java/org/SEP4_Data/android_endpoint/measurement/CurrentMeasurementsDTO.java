package org.SEP4_Data.android_endpoint.measurement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentMeasurementsDTO {

    private int temperature;
    private double humidity;
    private int co2;
    private boolean light;
    private Long device_id;
    private String device_location;
    private Date date;
    private String time;

}
