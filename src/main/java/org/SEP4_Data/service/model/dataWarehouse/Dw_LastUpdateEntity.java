package org.SEP4_Data.service.model.dataWarehouse;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Last_Update", schema = "sep4_dw", catalog = "sep4_DW")
public class Dw_LastUpdateEntity
{
    @Id
    @GeneratedValue
    private long id;
    private Date date;
    private Time time;

    @Basic
    @Column(name = "Date")
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @Basic
    @Column(name = "Time")
    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        this.time = time;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Dw_LastUpdateEntity that = (Dw_LastUpdateEntity) o;

        if (date != null ? !date.equals(that.date) : that.date != null)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
