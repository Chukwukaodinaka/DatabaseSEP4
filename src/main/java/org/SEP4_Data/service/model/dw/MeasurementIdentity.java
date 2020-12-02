package org.SEP4_Data.service.model.dw;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MeasurementIdentity implements Serializable {

//@ManyToOne

    private Integer d_device_Id;

//    @ManyToOne
    private Integer d_date_Id;

//    @ManyToOne
    private Integer d_time_Id;




}
