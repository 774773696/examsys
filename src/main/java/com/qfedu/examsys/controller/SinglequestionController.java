package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.ESinglequestions;
import com.qfedu.examsys.service.SinglequestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SinglequestionController {

    @Autowired(required = false)
    private SinglequestionsService singlequestionsService;


    @RequestMapping("/addsingle.do")
    @ResponseBody
    public JsonBean add(ESinglequestions singlequestions){
        System.out.println(singlequestions);
        System.out.println(singlequestions.getSqId());
        singlequestionsService.addSingleQuestions(singlequestions);

        return new JsonBean(0,"添加单选题成功");
    }



}
