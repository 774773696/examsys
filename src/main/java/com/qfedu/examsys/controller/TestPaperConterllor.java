package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.ESinglequestions;
import com.qfedu.examsys.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestPaperConterllor {

    @Autowired
    TestPaperService testPaperService;

    @RequestMapping("/findAllSingleQuestions.do")
    public Map<String,Object> findAllSingleQuestions(){

        List<ESinglequestions> list = testPaperService.findAllSingleQuestions();

        for (ESinglequestions li:list){
            System.out.println(li);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("data", list);

        return map;
    }

}
