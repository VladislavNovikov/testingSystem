package com.testingSystem.model.dao;

import com.testingSystem.model.entity.Test;

import java.util.List;

public interface TestDao {
    List<Test> getAllTests();
    //void addTest(Test test);
    //Test getTestById(Integer id);
}
