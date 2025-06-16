package com.example.courses.demo;

import com.example.demo.topics;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class course {
    @Id
    private String id;
    private String description;
    private String name;
    @ManyToOne
    private topics topic;
    
    public course(){
        
    }
    public course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description; 
        this.topic = new topics(topicId, "", "");
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setTopic(topics topic) {
          this.topic = topic; 
    }
}
