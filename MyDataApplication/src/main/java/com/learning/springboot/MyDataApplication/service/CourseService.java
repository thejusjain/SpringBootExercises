package com.learning.springboot.MyDataApplication.service;

import com.learning.springboot.MyDataApplication.model.Course;
import com.learning.springboot.MyDataApplication.model.Topic;
import com.learning.springboot.MyDataApplication.repository.CourseRepository;
import com.learning.springboot.MyDataApplication.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        System.out.println(courses);
        return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course); // save() function does both the update and the insert.
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
