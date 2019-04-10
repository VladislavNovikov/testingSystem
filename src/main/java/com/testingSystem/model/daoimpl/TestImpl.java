package com.testingSystem.model.daoimpl;

import com.testingSystem.model.dao.TestDao;
import com.testingSystem.model.entity.Question;
import com.testingSystem.model.entity.Test;
import com.testingSystem.model.mapper.TestMapper;
import com.testingSystem.spring.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TestImpl implements TestDao {

    private JdbcTemplate jdbcTemplate;
    private QuestionImpl questionImpl;

    @Autowired
    public TestImpl(AppConfig config, QuestionImpl questionImpl) {
        jdbcTemplate = new JdbcTemplate(config.dataSource());
        this.questionImpl = questionImpl;
    }

    public List<Test> getAllTests() {
        String SQL_GET_ALL_TESTS = "select * from testingsystem.test";
        return jdbcTemplate.query(SQL_GET_ALL_TESTS, new TestMapper());
    }

    public List<Test> getAllTestsByTopicId(int topicId) {
        String SQL_GET_ALL_TESTS = "select * from testingsystem.test where topicId = '"+topicId+"'";
        return jdbcTemplate.query(SQL_GET_ALL_TESTS, new TestMapper());
    }

    @Override
    public Test getTestByDescription(String test) {
        String SQL_GET_TEST_BY_DESCRIPTION = "select max(testId) as testId, name, description, topicId from testingsystem.test where description ='"+test+"'";
        return jdbcTemplate.queryForObject(SQL_GET_TEST_BY_DESCRIPTION, new TestMapper());
    }

    @Override
    public void addTestToDb(String topic, String test, String[] questions, String testID ) {
        String SQL_GET_TOPICID_BY_DESCRIPTION = "select distinct topicId from testingsystem.topic where description ='"+topic+"'";
        String SQL_ADD_TEST_TO_DB = "insert into test (name,description, topicId) values(?,?,?)";
        String SQL_GET_COUNT_OF_QUESTIONS_IN_CORRECT_TEST = "select count(questionId) from qt_conn where testId ='"+getTestByDescription(test).getTestId()+"'";

        if (testID.equals("")){
            jdbcTemplate.update(SQL_ADD_TEST_TO_DB, test, test, jdbcTemplate.queryForObject(SQL_GET_TOPICID_BY_DESCRIPTION, Integer.class));
            questionImpl.addQuestionsAndTestIdToQTConnection(questionImpl.getQuestionsIdByDescriptions(questions), test);
        }else {
            int testId = Integer.parseInt(testID);
            String SQL_GET_COUNT_OF_QUESTIONS_IN_TEST = "select count(questionId) from qt_conn where testId ='"+testId+"'";
            try{

                if (questions.length ==  jdbcTemplate.queryForObject(SQL_GET_COUNT_OF_QUESTIONS_IN_TEST, Integer.class)){
                    jdbcTemplate.update("update testingsystem.test set description = ? where testId=?", test, testId);

                }else {
                    if (questions.length !=  jdbcTemplate.queryForObject(SQL_GET_COUNT_OF_QUESTIONS_IN_CORRECT_TEST, Integer.class)) {
                        jdbcTemplate.update(SQL_ADD_TEST_TO_DB, test, test, jdbcTemplate.queryForObject(SQL_GET_TOPICID_BY_DESCRIPTION, Integer.class));
                        questionImpl.addQuestionsAndTestIdToQTConnection(questionImpl.getQuestionsIdByDescriptions(questions), test);
                    }
                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }}


    }


}
