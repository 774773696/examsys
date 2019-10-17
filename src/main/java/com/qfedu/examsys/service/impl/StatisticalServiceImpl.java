package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.StatisticalDao;
import com.qfedu.examsys.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//统计管理
@Service
public class StatisticalServiceImpl implements StatisticalService {


    @Autowired
    private StatisticalDao statisticalDao;

    //所有阶段
    @Override
    public List<String> findAllStage() {
        List<String> stageList=statisticalDao.findAllStage();
        return stageList;
    }

    //所有学科
    public List<String> findAllSubject() {
        List<String> subjectList=statisticalDao.findAllSubject();
        return subjectList;
    }

    //参与该阶段考试的所有学科
    @Override
    public List<String> findSubject(String stage) {
        List<String> subjects=statisticalDao.findSubject(stage);
        return subjects;
    }

    //该学科的所有阶段考试
    @Override
    public List<String> findStage(String subject) {
        List<String> stages = statisticalDao.findStage(subject);
        return stages;
    }

    //平均成绩
    @Override
    public Double averageScore(String subject,String stage) {

        double sum=0.0;
        //人数
        Integer users=statisticalDao.findAllUser(subject,stage);
        //分数集合
        List<Double> scoreList=statisticalDao.findAllScore(subject,stage);
        for(Double score:scoreList){
            sum+=score;
        }
        //平均分
        return sum/users;
    }
}
