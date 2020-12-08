package org.SEP4_Data.service.model.dataWarehouse;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "d_date", schema = "sep4_dw", catalog = "sep4_DW")
public class Dw_DDateEntity
{
    private int dDateId;
    private Date date;
    private String dayName;
    private int day;
    private String month;
    private int year;
    private int week;
    private int quarter;

    @Id
    @Column(name = "d_date_id")
    public int getdDateId()
    {
        return dDateId;
    }

    public void setdDateId(int dDateId)
    {
        this.dDateId = dDateId;
    }

    @Basic
    @Column(name = "date")
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @Basic
    @Column(name = "day_name")
    public String getDayName()
    {
        return dayName;
    }

    public void setDayName(String dayName)
    {
        this.dayName = dayName;
    }

    @Basic
    @Column(name = "day")
    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    @Basic
    @Column(name = "month")
    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    @Basic
    @Column(name = "year")
    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    @Basic
    @Column(name = "week")
    public int getWeek()
    {
        return week;
    }

    public void setWeek(int week)
    {
        this.week = week;
    }

    @Basic
    @Column(name = "quarter")
    public int getQuarter()
    {
        return quarter;
    }

    public void setQuarter(int quarter)
    {
        this.quarter = quarter;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Dw_DDateEntity that = (Dw_DDateEntity) o;

        if (dDateId != that.dDateId)
            return false;
        if (day != that.day)
            return false;
        if (year != that.year)
            return false;
        if (week != that.week)
            return false;
        if (quarter != that.quarter)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null)
            return false;
        if (dayName != null ? !dayName.equals(that.dayName) : that.dayName != null)
            return false;
        if (month != null ? !month.equals(that.month) : that.month != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = dDateId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (dayName != null ? dayName.hashCode() : 0);
        result = 31 * result + day;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + week;
        result = 31 * result + quarter;
        return result;
    }
}
