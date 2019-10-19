package com.qfedu.examsys.controller;

import com.qfedu.examsys.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//统计管理
@RestController
public class StatisticalController {

    @Autowired
    private StatisticalService statisticalService;


    @RequestMapping("/statisticalPage")
    public Map<String,Object> statisticalPage(){

        //所有阶段
        List<String> stageList = statisticalService.findAllStage();
        //所有学科
        List<String> subjectList = statisticalService.findAllSubject();
        //该阶段参与考试的学科
        List<String> subjects=statisticalService.findSubject("第一阶段");
        //各学科平均分
        List<Double> averageScores = new ArrayList<>();
        DecimalFormat df=new DecimalFormat(".00");
        for(String s:subjects){
            Double averageScore=statisticalService.averageScore(s,"第一阶段");
            if(averageScore.isNaN()){
                averageScore=0.00;
            }
            averageScores.add(Double.valueOf(df.format(averageScore)));
        }
        Map<String,Object> map=new HashMap<>();
        map.put("stageList",stageList);
        map.put("subjectList",subjectList);
        map.put("subjects",subjects);
        map.put("averageScores",averageScores);
        return map;
    }


    //该阶段各个学科平均考试成绩,默认展示第一阶段(根据阶段划分)
    @RequestMapping("/statisticalStage")
    public Map<String,Object> statisticalStage(String stage){

        //该阶段参与考试学科
        List<String> subjects=statisticalService.findSubject(stage);
        for(String s1:subjects){
            System.out.println(s1);
        }
        //该阶段各学科平均分
        List<Double> averageScores = new ArrayList<>();
        DecimalFormat df=new DecimalFormat(".00");
        for(String s:subjects){
            Double averageScore=statisticalService.averageScore(s,stage);
            if(averageScore.isNaN()){
                averageScore=0.00;
            }
            averageScores.add(Double.valueOf(df.format(averageScore)));
        }

        Map<String,Object> map=new HashMap<>();
        map.put("subjects",subjects);
        map.put("averageScores",averageScores);

        return map;
    }

    //该学科各个阶段平均考试成绩(根据学科划分)
    @RequestMapping("/statisticalSubject")
    public Map<String,Object> statisticalSubject(String subject){

        //该学科的所有考试阶段
        List<String> stages=statisticalService.findStage(subject);
        //该学科各阶段平均分
        List<Double> averageScores = new ArrayList<>();
        DecimalFormat df=new DecimalFormat(".00");
        for(String s:stages){
            Double averageScore=statisticalService.averageScore(subject,s);
            if(averageScore.isNaN()){
                averageScore=0.00;
            }
            averageScores.add(Double.valueOf(df.format(averageScore)));
        }

        Map<String,Object> map=new HashMap<>();
        map.put("stages",stages);
        map.put("averageScores",averageScores);

        return map;
    }
}
