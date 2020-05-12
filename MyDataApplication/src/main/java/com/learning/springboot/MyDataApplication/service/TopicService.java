package com.learning.springboot.MyDataApplication.service;

import com.learning.springboot.MyDataApplication.model.Topic;
import com.learning.springboot.MyDataApplication.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

//    // static data
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("Spring", "Spring Framework", "Spring desc"),
//            new Topic("JAVA", "Java Framework", "Java desc"),
//            new Topic("Python", "Python Framework", "Python desc")
//    ));

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i=0; i<topics.size(); i++){
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic); // save() function does both the update and the insert.
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
