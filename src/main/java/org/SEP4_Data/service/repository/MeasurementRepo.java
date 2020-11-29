package org.SEP4_Data.service.repository;

import org.SEP4_Data.service.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends JpaRepository<Data, Long> {

    Data findTopByOrderByIdDesc();
}
