package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class topicController {
    @Autowired
    private topicService topicservice;
    
        @RequestMapping("/topics")
            public List<topics> getAllTopics(){
                try {
                    return topicservice.getAllTopics();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return Arrays.asList(new topics("0", "No Subject Found", "Basic"));
            }
            @RequestMapping("/topics/{id}")
            public Optional<topics> getSingleTopic(@PathVariable String id){
                 return topicservice.getSingleTopic(id); 
            } 
            @RequestMapping(method=RequestMethod.POST, value ="/topics")
            public void addTopic(@RequestBody topics topic){
                   topicservice.addTopic(topic);
            }
            @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
            public void deleteSpecificTopics(@PathVariable String id){
                topicservice.deleteSpecificTopics(id);
            }
            @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
            public void updateTopic(@RequestBody topics topic, @PathVariable String id){
                topicservice.updateTopics(id, topic);
            }

}
