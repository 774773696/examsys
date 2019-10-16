package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.pojo.EAnswerquestions;
import com.qfedu.examsys.pojo.EMulquestions;
import com.qfedu.examsys.pojo.ESinglequestions;
import com.qfedu.examsys.pojo.EYnquestions;
import com.qfedu.examsys.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestPaperController {

    @Autowired
    TestPaperService testPaperService;

    @RequestMapping("/findAllSingleQuestions.do")
    public Map<String,Object> findAllSingleQuestions(Integer page, Integer limit){

        List<ESinglequestions> list = testPaperService.findAllSingleQuestions(page,limit);
        long total = ((Page) list).getTotal();

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        System.out.println("--------------------");
        System.out.println(list.toString());
        System.out.println(map.toString());
        System.out.println("---------------------");
        return map;
    }
    @RequestMapping("/findAllYnquestions.do")
    public Map<String,Object> findAllYnquestions(Integer page, Integer limit){

        List<EYnquestions> list = testPaperService.findAllYnquestions(page,limit);
        long total = ((Page) list).getTotal();
        for (EYnquestions li:list){
            System.out.println(li);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }
    @RequestMapping("/findAllMulquestions.do")
    public Map<String,Object> findAllMulquestions(Integer page, Integer limit){

        List<EMulquestions> list = testPaperService.findAllMulquestions(page,limit);
        long total = ((Page) list).getTotal();
        for (EMulquestions li:list){
            System.out.println(li);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }
    @RequestMapping("/findAllAnswerquestions.do")
    public Map<String,Object> findAllAnswerquestions(Integer page, Integer limit){

        List<EAnswerquestions> list = testPaperService.findAllAnswerquestions(page,limit);
        long total = ((Page) list).getTotal();
        for (EAnswerquestions li:list){
            System.out.println(li);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }
}
