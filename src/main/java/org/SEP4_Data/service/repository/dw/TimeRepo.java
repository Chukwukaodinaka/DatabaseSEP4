package org.SEP4_Data.service.repository.dw;


import org.SEP4_Data.service.model.dw.DTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepo extends JpaRepository<DTimeEntity, Integer> {
    @Query("select u from DTimeEntity as u where u.dTimeId =:id")
    DTimeEntity findDDateEntityByDDateId(Integer id);
}
