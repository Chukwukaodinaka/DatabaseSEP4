package org.SEP4_Data.service.repository.dw;

import org.SEP4_Data.service.model.dw.DDateEntity;
import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.MeasurementIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepo extends JpaRepository<DDateEntity, Integer> {
@Query("select u from DDateEntity as u where u.dDateId =:id")
    DDateEntity findDDateEntityByDDateId(Integer id);
}
