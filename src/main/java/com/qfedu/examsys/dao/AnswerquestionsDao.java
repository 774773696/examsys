package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.EAnswerquestions;

import java.util.List;

public interface AnswerquestionsDao {
    //查询所有的简答题
    public List<EAnswerquestions> findAllAnswerquestions();

    public void delAnswerquestions(int aqId);


}
