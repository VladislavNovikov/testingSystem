package com.testingSystem.controller;

import com.testingSystem.model.daoimpl.QuestionImpl;
import com.testingSystem.model.services.QuestionEditingService;
import com.testingSystem.model.services.QuestionStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QuestionController {

    private QuestionStatisticService questionStatisticService;
    private QuestionImpl questionImpl;
    private QuestionEditingService questionEditingService;

    @Autowired
    public QuestionController(QuestionStatisticService questionStatisticService, QuestionImpl questionImpl, QuestionEditingService questionEditingService) {
        this.questionStatisticService = questionStatisticService;
        this.questionImpl = questionImpl;
        this.questionEditingService = questionEditingService;
    }


    @GetMapping("/QuestionsInfo")
    public String showQuestionStatistic(Model model) {
        model.addAttribute("list",questionStatisticService.getQuestionInfoList());
        return "QuestionsInfo";
    }

    @GetMapping("/UpdateQuestion")
    public String updateQuestion(Model model){
        model.addAttribute("questions",questionImpl.getAllQuestions());
        return "UpdateQuestion";
    }

    @GetMapping("/CreateQuestion")
    public String createQuestion(Model model){
        model.addAttribute("questions",questionImpl.getAllQuestions());
        return "CreateQuestion";
    }

    @PostMapping("/CreateQuestion")
    public String createQuestion(@RequestParam(name = "btn") String button, @RequestParam(name = "question", required = false ) String question) {
        return questionEditingService.addByButton(button, question);
    }


}
