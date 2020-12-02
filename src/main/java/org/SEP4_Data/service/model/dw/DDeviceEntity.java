package org.SEP4_Data.service.model.dw;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "d_device", schema = "sep4_DW", catalog = "database_DW")
public class DDeviceEntity {
    private Integer dDeviceId;
    private Long deviceId;
    private String name;
    private String eui;
    private String location;
    private Date validFrom;
    private Date validTil;

    @Basic
    @Column(name = "d_device_id", nullable = false)
    public Integer getdDeviceId() {
        return dDeviceId;
    }

    public void setdDeviceId(Integer dDeviceId) {
        this.dDeviceId = dDeviceId;
    }

    @Id
    @Column(name = "device_id", nullable = false)
    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "eui", nullable = true, length = 255)
    public String getEui() {
        return eui;
    }

    public void setEui(String eui) {
        this.eui = eui;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 30)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "validFrom", nullable = true)
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Basic
    @Column(name = "validTil", nullable = false)
    public Date getValidTil() {
        return validTil;
    }

    public void setValidTil(Date validTil) {
        this.validTil = validTil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DDeviceEntity that = (DDeviceEntity) o;

        if (dDeviceId != null ? !dDeviceId.equals(that.dDeviceId) : that.dDeviceId != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (eui != null ? !eui.equals(that.eui) : that.eui != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (validFrom != null ? !validFrom.equals(that.validFrom) : that.validFrom != null) return false;
        if (validTil != null ? !validTil.equals(that.validTil) : that.validTil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dDeviceId != null ? dDeviceId.hashCode() : 0;
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (eui != null ? eui.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validTil != null ? validTil.hashCode() : 0);
        return result;
    }
}
