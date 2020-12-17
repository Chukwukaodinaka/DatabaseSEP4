package org.SEP4_Data.service.model.dataWarehouse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "f_measurements", schema = "sep4_dw", catalog = "sep4_DW")
public class Dw_FMeasurementsEntity
{
    @Id
    @EmbeddedId
    MeasurementIdentity id;
    private int co2;
    private double humidity;
    private boolean light;
    private double temperature;
}
