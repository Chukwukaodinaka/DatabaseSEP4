package org.SEP4_Data.service.repository.dw;

import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.MeasurementIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends JpaRepository<DMeasurementsEntity, MeasurementIdentity> {

    DMeasurementsEntity findTopByOrderByIdDesc();
}
