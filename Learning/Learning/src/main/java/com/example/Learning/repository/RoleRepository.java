package com.example.Learning.repository;

import com.example.Learning.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT r.role_name FROM role_info r WHERE r.role_id in (:roleIds)",
            nativeQuery = true) // Query must have real table names and columns
    public List<String> findRoleNames(List<Integer> roleIds);
}
