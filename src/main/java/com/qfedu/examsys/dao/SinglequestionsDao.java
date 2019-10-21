package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.ESinglequestions;

import java.util.List;

public interface SinglequestionsDao {


    //查询所有的单选题
    public List<ESinglequestions> findAllSingleQuestions();

    //添加单选题
    public void addSingleQuestions(ESinglequestions singlequestions);

    //删除单选（一行）
    public void delSingleQuestions(int sqId);


    public ESinglequestions updateSingleQuestions(int sqId);
}
