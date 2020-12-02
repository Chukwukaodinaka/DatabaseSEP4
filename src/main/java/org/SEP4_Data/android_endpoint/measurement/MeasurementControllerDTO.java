package org.SEP4_Data.android_endpoint.measurement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementControllerDTO {

    private Integer temperature;
    private Integer humidity;
    private Integer co2;
    private Boolean light;
    private Long device_id;
    private Date date;
    private String time;

}
