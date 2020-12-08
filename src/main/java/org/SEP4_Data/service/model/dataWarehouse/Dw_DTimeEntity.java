package org.SEP4_Data.service.model.dataWarehouse;

import javax.persistence.*;

@Entity
@Table(name = "d_time", schema = "sep4_dw", catalog = "sep4_DW")
public class Dw_DTimeEntity
{
    private int dTimeId;
    private String time;
    private String hour;
    private String minute;

    @Id
    @Column(name = "d_time_id")
    public int getdTimeId()
    {
        return dTimeId;
    }

    public void setdTimeId(int dTimeId)
    {
        this.dTimeId = dTimeId;
    }

    @Basic
    @Column(name = "time")
    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    @Basic
    @Column(name = "hour")
    public String getHour()
    {
        return hour;
    }

    public void setHour(String hour)
    {
        this.hour = hour;
    }

    @Basic
    @Column(name = "minute")
    public String getMinute()
    {
        return minute;
    }

    public void setMinute(String minute)
    {
        this.minute = minute;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Dw_DTimeEntity that = (Dw_DTimeEntity) o;

        if (dTimeId != that.dTimeId)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null)
            return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null)
            return false;
        if (minute != null ? !minute.equals(that.minute) : that.minute != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = dTimeId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        result = 31 * result + (minute != null ? minute.hashCode() : 0);
        return result;
    }
}
