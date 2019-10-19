package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.ESubject;

import java.util.List;

//科目
public interface SubjectDao {
    /**
     *查询所有的科目
     */
    public List<ESubject> findAllSubject();
}
