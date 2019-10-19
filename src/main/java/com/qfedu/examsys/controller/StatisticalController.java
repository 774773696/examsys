package com.qfedu.examsys.controller;

import com.qfedu.examsys.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//统计管理
@Controller
@RequestMapping("/statistical")
public class StatisticalController {

    @Autowired
    private StatisticalService statisticalService;

    //所有阶段考试各个学科平均考试成绩,默认展示第一阶段(根据阶段划分)
    @RequestMapping("/statisticalStage")
    public String statisticalStage(String stage, Model model){

        if(stage==null||stage.equals("")){
            stage="第一阶段考试";
        }

        //所有阶段
        List<String> stageList = statisticalService.findAllStage();
        //所有学科
        List<String> subjectList = statisticalService.findAllSubject();
        //该阶段参与考试的学科
        List<String> subjects=statisticalService.findSubject(stage);
        //各学科平均分
        List<Double> averageScoreList = new ArrayList<>();
        DecimalFormat df=new DecimalFormat(".00");
        for(String s:subjects){
            Double averageScore=statisticalService.averageScore(s,stage);
            if(averageScore.isNaN()){
                averageScore=0.00;
            }
            averageScoreList.add(Double.valueOf(df.format(averageScore)));
        }

        model.addAttribute("stage",stage);
        model.addAttribute("stageList",stageList);
        model.addAttribute("subjectList",subjectList);
        model.addAttribute("subjects",subjects);
        model.addAttribute("averageScoreList",averageScoreList);

        return "statistical";
    }

    //所有学科考试各个阶段平均考试成绩(根据学科划分)
    @RequestMapping("/statisticalSubject")
    public String statisticalSubject(String subject, Model model){

        if(subject==null||subject.equals("")){
            subject="语文";
        }

        //所有阶段
        List<String> stageList = statisticalService.findAllStage();
        //所有学科
        List<String> subjectList = statisticalService.findAllSubject();
        //该学科的所有阶段考试
        List<String> stages=statisticalService.findStage(subject);

        //各学科平均分
        List<Double> averageScoreList = new ArrayList<>();
        DecimalFormat df=new DecimalFormat(".00");
        for(String s:stages){
            Double averageScore=statisticalService.averageScore(subject,s);
            if(averageScore.isNaN()){
                averageScore=0.00;
            }
            averageScoreList.add(Double.valueOf(df.format(averageScore)));
        }

        model.addAttribute("subject",subject);
        model.addAttribute("stageList",stageList);
        model.addAttribute("subjectList",subjectList);
        model.addAttribute("stages",stages);
        model.addAttribute("averageScoreList",averageScoreList);

        return "statistical";
    }
}
