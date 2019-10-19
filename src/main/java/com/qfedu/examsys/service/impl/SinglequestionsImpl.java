package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.SinglequestionsDao;
import com.qfedu.examsys.pojo.ESinglequestions;
import com.qfedu.examsys.service.SinglequestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinglequestionsImpl implements SinglequestionsService {


    @Autowired(required = false)
    private SinglequestionsDao singlequestionsDao;


    @Override
    public void addSingleQuestions(ESinglequestions singlequestions) {

        singlequestionsDao.addSingleQuestions(singlequestions);
    }
}
