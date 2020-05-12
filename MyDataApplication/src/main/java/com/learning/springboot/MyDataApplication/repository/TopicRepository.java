package com.learning.springboot.MyDataApplication.repository;

import com.learning.springboot.MyDataApplication.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {


}
