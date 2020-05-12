package com.learning.springboot.MyDataApplication.repository;

import com.learning.springboot.MyDataApplication.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    List<Course> findByTopicId(String topicId);
}
