package org.SEP4_Data.service.model.dataWarehouse;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "d_device", schema = "sep4_dw", catalog = "sep4_DW")
public class Dw_DDeviceEntity
{
    @Id
    private int d_Device_Id;
    private long deviceId;
    private String name;
    private String eui;
    private String location;
    private Date validfrom;
    private Date validtil;

    @Basic
    @Column(name = "d_device_id")
    public int getdDeviceId()
    {
        return d_Device_Id;
    }

    public void setdDeviceId(int dDeviceId)
    {
        this.d_Device_Id = dDeviceId;
    }

    @Basic
    @Column(name = "device_id")
    public long getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(long deviceId)
    {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "eui")
    public String getEui()
    {
        return eui;
    }

    public void setEui(String eui)
    {
        this.eui = eui;
    }

    @Basic
    @Column(name = "location")
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Basic
    @Column(name = "validfrom")
    public Date getValidfrom()
    {
        return validfrom;
    }

    public void setValidfrom(Date validfrom)
    {
        this.validfrom = validfrom;
    }

    @Basic
    @Column(name = "validtil")
    public Date getValidtil()
    {
        return validtil;
    }

    public void setValidtil(Date validtil)
    {
        this.validtil = validtil;
    }


}
