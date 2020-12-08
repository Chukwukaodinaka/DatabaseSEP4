package org.SEP4_Data.service.model.dataWarehouse;


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



    private Integer d_device_Id;

    private Integer d_date_Id;

    private Integer d_time_Id;

    @Basic
    @JoinColumn(name = "d_device_id")
    public int getdDeviceId()
    {
        return d_device_Id;
    }

    public void setdDeviceId(int dDeviceId)
    {
        this.d_device_Id = dDeviceId;
    }

    @Basic
    @JoinColumn(name = "d_date_id")
    public int getdDateId()
    {
        return d_date_Id;
    }

    public void setdDateId(int dDateId)
    {
        this.d_date_Id = dDateId;
    }

    @Basic
    @JoinColumn(name = "d_time_id")
    public int getdTimeId()
    {
        return d_time_Id;
    }

    public void setdTimeId(int dTimeId)
    {
        this.d_time_Id = dTimeId;
    }



}
