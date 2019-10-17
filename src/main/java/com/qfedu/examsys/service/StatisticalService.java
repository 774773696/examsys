package com.qfedu.examsys.service;

import java.util.List;

//统计管理
public interface StatisticalService {
    //所有阶段
    public List<String> findAllStage();
    //所有学科
    public List<String> findAllSubject();
    //参与该阶段考试的所有学科
    public List<String> findSubject(String stage);
    //该学科的所有阶段考试
    public List<String> findStage(String subject);
    //平均成绩
    public Double averageScore(String subject,String stage);

}
