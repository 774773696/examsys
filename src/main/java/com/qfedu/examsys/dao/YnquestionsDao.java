package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.EYnquestions;

import java.util.List;

public interface YnquestionsDao {
    //查询所有的单选题
    public List<EYnquestions> findAllYnquestions();

    public void delYnquestions(int yqId);

    public EYnquestions updateYnquestions(int yqId);


}
