package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.EMulquestions;

import java.util.List;

public interface MulquestionsDao {
    //查询所有的单选题
    public List<EMulquestions> findAllMulquestions();

    public void delMulquestions(int mqId);

    public EMulquestions updateMulquestions(int mqId);
}
