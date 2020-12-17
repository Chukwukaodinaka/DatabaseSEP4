package org.SEP4_Data.service.repository.dw;

import org.SEP4_Data.service.model.dataWarehouse.Dw_FMeasurementsEntity;
import org.SEP4_Data.service.model.dataWarehouse.MeasurementIdentity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface MeasurementRepo extends JpaRepository<Dw_FMeasurementsEntity, MeasurementIdentity > {
    @Query(value = " select m from Dw_FMeasurementsEntity as m INNER JOIN Dw_DDeviceEntity as d on m.id.d_device_Id = d.d_Device_Id WHERE d.location =:location  ORDER BY m.id DESC ")
    List< Dw_FMeasurementsEntity >findCurrentByLocation(@Param("location") String location, Pageable pageable);

    @Query(value = "select m.temperature from Dw_FMeasurementsEntity as m Inner join Dw_DDateEntity as da on m.id.d_date_Id = da.dDateId INNER JOIN Dw_DDeviceEntity as d on m.id.d_device_Id = d.d_Device_Id where d.location =:location and da.date >=:from and da.date <=:to")
    List<Double> getTempHistory(@Param("location") String location, @Param("from") Date from, @Param("to") Date to);

    @Query(value = "select m.co2 from Dw_FMeasurementsEntity as m Inner join Dw_DDateEntity as da on m.id.d_date_Id = da.dDateId INNER JOIN Dw_DDeviceEntity as d on m.id.d_device_Id = d.d_Device_Id where d.location =:location and da.date >=:from and da.date <=:to")
    List<Float> getCo2History(@Param("location") String location, @Param("from")Date from, @Param("to") Date to);

    @Query(value = "select m.humidity from Dw_FMeasurementsEntity as m Inner join Dw_DDateEntity as da on m.id.d_date_Id = da.dDateId INNER JOIN Dw_DDeviceEntity as d on m.id.d_device_Id = d.d_Device_Id where d.location =:location and da.date >=:from and da.date <=:to")
    List<Double> getHumidityHistory(@Param("location") String location, @Param("from")Date from, @Param("to") Date to);

    @Query(value = "select m.light from Dw_FMeasurementsEntity as m Inner join Dw_DDateEntity as da on m.id.d_date_Id = da.dDateId INNER JOIN Dw_DDeviceEntity as d on m.id.d_device_Id = d.d_Device_Id where d.location =:location and da.date >=:from and da.date <=:to")
    List<Boolean> getLightHistory(@Param("location") String location, @Param("from")Date from, @Param("to") Date to);

}
