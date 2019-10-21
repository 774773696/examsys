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

    @Autowired(required = false)
    private TestPaperDao testPaperDao;


    //查询所有的科目
    @Override
    public List<ESubject> findAllSubject() {
        List<ESubject> eSubjects = subjectDao.findAllSubject();
        if (eSubjects.isEmpty()) {
            throw new RuntimeException("没有此科目，完善科目");
        }
        return eSubjects;
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
    public List<ETestpaper> findtestPaperBySubjectId(Integer subjectId) {
        return testPaperDao.findtestPaperBySubjectId(subjectId);
    }

    @Override
    public List<ETestpaper> findAllTestPaper() {
        return testPaperDao.findAllTestPaper();
    }

    @Override
    public void delAnswerquestions(int aqId) {
        answerquestionsDao.delAnswerquestions(aqId);
    }

    @Override
    public void delMulquestions(int mqId) {
        mulquestionsDao.delMulquestions(mqId);
    }

    @Override
    public void delSingleQuestions(int sqId) {
        singlequestionsDao.delSingleQuestions(sqId);
    }

    @Override
    public void delYnquestions(int yqId) {
        ynquestionsDao.delYnquestions(yqId);
    }


    @Override
    public void importSinglequestions() {

    }
}
