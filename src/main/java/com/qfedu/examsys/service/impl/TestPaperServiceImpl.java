package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.SubjectDao;
import com.qfedu.examsys.pojo.ESubject;
import com.qfedu.examsys.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestPaperServiceImpl implements TestPaperService {

    @Autowired
    SubjectDao subjectDao;
    //查询所有的科目
    @Override
    public List<ESubject> findAllSubject() {
        return subjectDao.findAllSubject();
    }
}
