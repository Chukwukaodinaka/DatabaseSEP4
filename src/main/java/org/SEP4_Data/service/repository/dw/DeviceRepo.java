package org.SEP4_Data.service.repository.dw;


import org.SEP4_Data.service.model.dataWarehouse.Dw_DDeviceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepo extends JpaRepository<Dw_DDeviceEntity, Integer> {
    @Query("select u from Dw_DDeviceEntity as u where u.location =:location")
    Dw_DDeviceEntity findDeviceByLocation(String location);
}
