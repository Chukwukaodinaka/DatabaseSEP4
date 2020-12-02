package org.SEP4_Data.service.model.dw;

import javax.persistence.*;

@Entity
@Table(name = "d_time", schema = "sep4_DW", catalog = "database_DW")
public class DTimeEntity {
    private Integer dTimeId;
    private String time;
    private String hour;
    private String minute;

    @Id
    @Column(name = "d_time_id", nullable = false)
    public Integer getdTimeId() {
        return dTimeId;
    }

    public void setdTimeId(Integer dTimeId) {
        this.dTimeId = dTimeId;
    }

    @Basic
    @Column(name = "time", nullable = false, length = 5)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "hour", nullable = false, length = 2)
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Basic
    @Column(name = "minute", nullable = true, length = 2)
    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DTimeEntity that = (DTimeEntity) o;

        if (dTimeId != null ? !dTimeId.equals(that.dTimeId) : that.dTimeId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;
        if (minute != null ? !minute.equals(that.minute) : that.minute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dTimeId != null ? dTimeId.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        result = 31 * result + (minute != null ? minute.hashCode() : 0);
        return result;
    }
}
