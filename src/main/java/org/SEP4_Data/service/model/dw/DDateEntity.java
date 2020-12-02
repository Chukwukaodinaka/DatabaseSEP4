package org.SEP4_Data.service.model.dw;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "d_date", schema = "sep4_DW", catalog = "database_DW")
public class DDateEntity {
    private Integer dDateId;
    private Date date;
    private String dayName;
    private Integer day;
    private String month;
    private Integer year;
    private Integer week;
    private Integer quarter;

    @Id
    @Column(name = "d_date_id", nullable = false)
    public Integer getdDateId() {
        return dDateId;
    }

    public void setdDateId(Integer dDateId) {
        this.dDateId = dDateId;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "day_name", nullable = false, length = 10)
    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Basic
    @Column(name = "day", nullable = false)
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Basic
    @Column(name = "month", nullable = false, length = 10)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Basic
    @Column(name = "year", nullable = false)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "week", nullable = false)
    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    @Basic
    @Column(name = "quarter", nullable = false)
    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DDateEntity that = (DDateEntity) o;

        if (dDateId != null ? !dDateId.equals(that.dDateId) : that.dDateId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (dayName != null ? !dayName.equals(that.dayName) : that.dayName != null) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (week != null ? !week.equals(that.week) : that.week != null) return false;
        if (quarter != null ? !quarter.equals(that.quarter) : that.quarter != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dDateId != null ? dDateId.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (dayName != null ? dayName.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (week != null ? week.hashCode() : 0);
        result = 31 * result + (quarter != null ? quarter.hashCode() : 0);
        return result;
    }
}
