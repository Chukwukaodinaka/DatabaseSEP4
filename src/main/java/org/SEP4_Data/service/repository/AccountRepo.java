package org.SEP4_Data.service.repository;

import org.SEP4_Data.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepo extends JpaRepository<User, Long> {
    @Query(value = "select * from Account a where a.username = :username and a.password = :password", nativeQuery = true)
    User findUser(@Param("username") String username,@Param("password") String password);
}
