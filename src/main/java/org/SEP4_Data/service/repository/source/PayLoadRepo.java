package org.SEP4_Data.service.repository.source;


import org.SEP4_Data.service.model.source.PayLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayLoadRepo extends JpaRepository<PayLoad, Long> {
}
