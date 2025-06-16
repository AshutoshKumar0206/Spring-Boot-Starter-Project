package com.example.courses.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topics;

@RestController
public class coursesController {
    @Autowired
    private courseService courseservice;
    
        @RequestMapping("/topics/{id}/courses")
            public List<course> getAllCourses(@PathVariable String id) {
                return courseservice.getAllCourses(id);
            }
            @RequestMapping("/topics/{topicId}/courses/{id}")
            public Optional<course> getSingleCourse(@PathVariable String id){
                 return courseservice.getSingleCourse(id); 
            } 
            @RequestMapping(method=RequestMethod.POST, value ="/topics/{topicId}/courses")
            public void addTopic(@RequestBody course courses, @PathVariable String topicId){
                   courses.setTopic( new topics(topicId, "", ""));
                   courseservice.addCourse(courses);
            }
            @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
            public void deleteSpecificTopics(@PathVariable String id){
                courseservice.deleteSpecificCourses(id);
            }
            @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
            public void updateTopic(@RequestBody course courses, @PathVariable String id, @PathVariable String topicId){
                courses.setTopic( new topics(topicId, "", ""));
                courseservice.updateCourse(courses);
            }

}
