package com.example.DatabaseConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);
    // We can initialise any methods here. The syntax is
    // findBy <Filed containing, >
}
