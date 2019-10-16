package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.ESinglequestions;

import java.util.List;

public interface SinglequestionsDao {


    //查询所有的单选题
    public List<ESinglequestions> findAllSingleQuestions();

    //添加单选题
    public void addSingleQuestions(ESinglequestions singlequestions);
}
