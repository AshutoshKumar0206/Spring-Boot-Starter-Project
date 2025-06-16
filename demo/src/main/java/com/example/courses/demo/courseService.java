package com.example.courses.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseService {
 @Autowired
    private courseRepository courserepository;
            
            public List<course> getAllCourses(String id){
                List<course> courses = new ArrayList<>();
                courserepository.findAll().forEach(courses::add);
                return courses; 
            }
            public Optional<course> getSingleCourse(String id){
                // return topic.stream().filter(t -> t.getId().equals(id)).findFirst().get();
                return courserepository.findById(id);
            }
            public void addCourse(course courses){
                courserepository.save(courses);
            }
            public void deleteSpecificCourses(String id){
                // topic.removeIf(topic->topic.getId().equals(id));
                courserepository.deleteById(id);
            }
            public void updateCourse(course courses){
                //  for(int i = 0; i<topic.size(); i++){
                //     topics t = topic.get(i);
                //     if(t.getId().equals(id)){
                //         topic.set(i, topice);
                //         return;
                //     }    
                //  }
                courserepository.save(courses);
            }

}

