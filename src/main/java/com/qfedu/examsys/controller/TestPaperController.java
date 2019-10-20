package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.*;
import com.qfedu.examsys.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

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

    @RequestMapping("/uploadSingleQuestion.do")
    public Map<String, Object> uploadSingleQuestion(@RequestParam("file") MultipartFile file) {
            HashMap<String, Object> map = new HashMap<>();
        try {
            testPaperService.uploadSingleQuestion(file);
            map.put("code", 0);
            map.put("info", "上传成功");
            return map;
        } catch (Exception e) {
            map.put("code", 1);
            map.put("info", "上传失败");
            return map;
        }
    }
}
