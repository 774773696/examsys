package com.qfedu.examsys.service;

import com.qfedu.examsys.pojo.ESubject;

import java.util.List;

public interface TestPaperService {
    //查询所有试题的科目
    public List<ESubject> findAllSubject();
}
