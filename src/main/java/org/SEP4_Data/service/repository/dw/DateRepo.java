package org.SEP4_Data.service.repository.dw;

import org.SEP4_Data.service.model.dataWarehouse.Dw_DDateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepo extends JpaRepository<Dw_DDateEntity, Integer> {
@Query("select u from Dw_DDateEntity as u where u.dDateId =:id")
Dw_DDateEntity findDDateEntityByDDateId(Integer id);
}
