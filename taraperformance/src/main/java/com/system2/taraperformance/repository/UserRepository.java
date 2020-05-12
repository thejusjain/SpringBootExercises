package com.system2.taraperformance.repository;

import com.system2.taraperformance.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

//    List<String> getAccountIds();

}
