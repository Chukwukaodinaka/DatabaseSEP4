package org.SEP4_Data.service.model.dw;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "d_measurements", schema = "sep4_DW", catalog = "database_DW")
public class DMeasurementsEntity {

    @Id
    @EmbeddedId
    MeasurementIdentity id;

    private Integer co2;
    private Integer humidity;
    private Boolean light;
    private Integer temperature;


}
