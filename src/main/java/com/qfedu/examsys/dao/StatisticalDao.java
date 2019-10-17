package com.qfedu.examsys.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

//统计管理
@Repository
public interface StatisticalDao {

    //所有阶段
    public List<String> findAllStage();

    //所有学科
    public List<String> findAllSubject();

    //该阶段考试的所有学科
    public List<String> findSubject(String stage);

    //该学科的所有阶段考试
    public List<String> findStage(String subject);

    //查询该阶段该学科考试的参加人数
    public Integer findAllUser(String subject,String stage);

    //查询该阶段该学科考试的总分
    public List<Double> findAllScore(String subject,String stage);

}
