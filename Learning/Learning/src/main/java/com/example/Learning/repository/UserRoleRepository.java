package com.example.Learning.repository;

import com.example.Learning.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query(value = "SELECT ur.role_id from user_role ur where user_id = ?1",
    nativeQuery = true)
    public List<Integer> findRoleId(int userId);
}
