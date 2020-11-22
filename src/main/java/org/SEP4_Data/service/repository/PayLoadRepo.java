package org.SEP4_Data.service.repository;

import org.SEP4_Data.service.model.Measurements;
import org.SEP4_Data.service.model.PayLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayLoadRepo extends JpaRepository<PayLoad, Long> {
}
