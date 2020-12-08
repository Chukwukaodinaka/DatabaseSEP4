package org.SEP4_Data.service.repository.dw;

import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.MeasurementIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends JpaRepository<DMeasurementsEntity, MeasurementIdentity> {
    @Query( nativeQuery = true, value = "select m from DMeasurementsEntity m INNER JOIN DDeviceEntity as d WHERE d.location =:location ORDER BY m.id DESC LIMIT 0,1")
    DMeasurementsEntity findCurrentByLocation(@Param("location") String location);
}
