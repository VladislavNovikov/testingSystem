package com.testingSystem.model.services;

import com.google.gson.Gson;

import com.testingSystem.model.daoimpl.QuestionImpl;
import com.testingSystem.model.daoimpl.TopicImpl;
import com.testingSystem.model.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSelectTopicTest {
    private QuestionImpl questionImpl;
    private TopicImpl topicIml;

    @Autowired
    public UserSelectTopicTest(QuestionImpl questionImpl, TopicImpl topicIml) {
        this.questionImpl = questionImpl;
        this.topicIml = topicIml;
    }

    public String getAllTest(){
        Gson gson = new Gson();
        return gson.toJson(questionImpl.getAllQuestions());
    }

    public List<Topic> getAllTopics() {
        return topicIml.getAllTopics();
    }
}
