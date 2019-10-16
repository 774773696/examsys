package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.SinglequestionsDao;
import com.qfedu.examsys.dao.SubjectDao;
import com.qfedu.examsys.pojo.ESinglequestions;
import com.qfedu.examsys.pojo.ESubject;
import com.qfedu.examsys.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestPaperServiceImpl implements TestPaperService {

    @Autowired(required = false)
    private SubjectDao subjectDao;

    @Autowired(required = false)
    private SinglequestionsDao singlequestionsDao;


    //查询所有的科目
    @Override
    public List<ESubject> findAllSubject() {
        return subjectDao.findAllSubject();
    }

    //查询所有的单选题目
    @Override
    public List<ESinglequestions> findAllSingleQuestions() {
        return singlequestionsDao.findAllSingleQuestions();
    }
}
