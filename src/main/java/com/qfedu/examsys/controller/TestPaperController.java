package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.*;
import com.qfedu.examsys.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
        return map;
    }
    @RequestMapping("/findAllYnquestions.do")
    public Map<String,Object> findAllYnquestions(Integer page, Integer limit){

        List<EYnquestions> list = testPaperService.findAllYnquestions(page,limit);
        long total = ((Page) list).getTotal();
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

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }

    @RequestMapping("/findtestpaperbyid.do")
    public JsonBean findtestPaperBySubjectId(Integer subjectId){
        List<ETestpaper> tpList = testPaperService.findtestPaperBySubjectId(subjectId);
        return new JsonBean(0, tpList);
    }

    @RequestMapping("/findAllTestPaper.do")
    public JsonBean findAllTestPaper() {
        List<ETestpaper> eTestpaperList = testPaperService.findAllTestPaper();
        if (eTestpaperList == null) {
            throw new RuntimeException("没有试卷，请生成");
        }
        return new JsonBean(0, eTestpaperList);
    }
    @RequestMapping("/delTestPaper.do")
    public JsonBean delTestPaper(HttpServletRequest request) {
        String sqId = request.getParameter("sqId");
        String aqId = request.getParameter("aqId");
        String yqId = request.getParameter("yqId");
        String mqId = request.getParameter("mqId");
/*        System.out.println(sqId+"sqId");
        System.out.println(aqId+"aqId");
        System.out.println(yqId+"yqId");
        System.out.println(mqId+"mqId");*/

        if (sqId != null){
            testPaperService.delSingleQuestions(Integer.valueOf(sqId));
            return new JsonBean(0, null);
        }
        if(aqId != null){
            testPaperService.delAnswerquestions(Integer.valueOf(aqId));
            return new JsonBean(0, null);

        }
        if(yqId != null){
            testPaperService.delYnquestions(Integer.valueOf(yqId));
            return new JsonBean(0, null);

        }
        if(mqId != null){
            testPaperService.delMulquestions(Integer.valueOf(mqId));
            return new JsonBean(0, null);

        }
        return new JsonBean(1, "error");


    }
}
