package org.SEP4_Data.service.repository.dw;

import org.SEP4_Data.service.model.dataWarehouse.Dw_FMeasurementsEntity;
import org.SEP4_Data.service.model.dataWarehouse.MeasurementIdentity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepo extends JpaRepository<Dw_FMeasurementsEntity, MeasurementIdentity > {
    @Query(value = " select m from Dw_FMeasurementsEntity as m INNER JOIN Dw_DDeviceEntity as d on m.id.d_device_Id = d.d_Device_Id WHERE d.location =:location  ORDER BY m.id DESC ")
    List< Dw_FMeasurementsEntity >findCurrentByLocation(@Param("location") String location, Pageable pageable);
}
