package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.*;
import com.qfedu.examsys.pojo.*;
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

    @Autowired(required = false)
    private YnquestionsDao ynquestionsDao;

    @Autowired(required = false)
    private MulquestionsDao mulquestionsDao;

    @Autowired(required = false)
    private AnswerquestionsDao answerquestionsDao;


    //查询所有的科目
    @Override
    public List<ESubject> findAllSubject() {
        return subjectDao.findAllSubject();
    }

    //查询所有的单选题目
    @Override
    public List<ESinglequestions> findAllSingleQuestions(Integer page, Integer limit) {
        //设置查询的页码和每页显示的记录数
        //该语句后面，一定要紧跟着查询用的方法
        PageHelper.startPage(page,limit);
        return singlequestionsDao.findAllSingleQuestions();
    }

    @Override
    public List<EYnquestions> findAllYnquestions(Integer page, Integer limit) {
        //设置查询的页码和每页显示的记录数
        //该语句后面，一定要紧跟着查询用的方法
        PageHelper.startPage(page,limit);
        return ynquestionsDao.findAllYnquestions();
    }

    @Override
    public List<EMulquestions> findAllMulquestions(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return mulquestionsDao.findAllMulquestions();
    }

    @Override
    public List<EAnswerquestions> findAllAnswerquestions(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return answerquestionsDao.findAllAnswerquestions();
    }

    @Override
    public void importSinglequestions() {

    }
}
