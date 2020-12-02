package org.SEP4_Data.service.repository.source;

<<<<<<< HEAD:src/main/java/org/SEP4_Data/service/repository/PayLoadRepo.java
import org.SEP4_Data.service.model.PayLoad;
=======
import org.SEP4_Data.service.model.source.PayLoad;
>>>>>>> second_database_datasource:src/main/java/org/SEP4_Data/service/repository/source/PayLoadRepo.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayLoadRepo extends JpaRepository<PayLoad, Long> {
}
