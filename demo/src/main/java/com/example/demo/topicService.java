package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class topicService {
 @Autowired
    private topicRepository topicrepository;
            
            public List<topics> getAllTopics(){
                List<topics> topice = new ArrayList<>();
                topicrepository.findAll().forEach(topice::add);
                return topice;
            }
            public Optional<topics> getSingleTopic(String id){
                // return topic.stream().filter(t -> t.getId().equals(id)).findFirst().get();
                return topicrepository.findById(id);
            }
            public void addTopic(topics topice){
                topicrepository.save(topice);
            }
            public void deleteSpecificTopics(String id){
                // topic.removeIf(topic->topic.getId().equals(id));
                topicrepository.deleteById(id);
            }
            public void updateTopics(String id, topics topice){
                //  for(int i = 0; i<topic.size(); i++){
                //     topics t = topic.get(i);
                //     if(t.getId().equals(id)){
                //         topic.set(i, topice);
                //         return;
                //     }    
                //  }
                topicrepository.save(topice);
            }

}

