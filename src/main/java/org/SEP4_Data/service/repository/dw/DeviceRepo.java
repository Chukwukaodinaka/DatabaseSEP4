package org.SEP4_Data.service.repository.dw;


import org.SEP4_Data.service.model.dw.DDeviceEntity;
import org.SEP4_Data.service.model.dw.DMeasurementsEntity;
import org.SEP4_Data.service.model.dw.MeasurementIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepo extends JpaRepository<DDeviceEntity, Integer> {
    @Query("select u from DDeviceEntity as u where u.location =:location")
    DDeviceEntity findDeviceByLocation(String location);
}
