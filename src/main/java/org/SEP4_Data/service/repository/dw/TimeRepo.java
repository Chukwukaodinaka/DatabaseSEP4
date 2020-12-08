package org.SEP4_Data.service.repository.dw;


import org.SEP4_Data.service.model.dataWarehouse.Dw_DTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepo extends JpaRepository<Dw_DTimeEntity, Integer> {
    @Query("select u from Dw_DTimeEntity as u where u.dTimeId =:id")
    Dw_DTimeEntity findDDateEntityByDDateId(Integer id);
}
