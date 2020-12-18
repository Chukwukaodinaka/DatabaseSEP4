package org.SEP4_Data.android_endpoint.measurement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentMeasurementsDTO {

    private double temperature;
    private double humidity;
    private int co2;
    private boolean light;

}
