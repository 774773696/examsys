package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.ETestpaper;

import java.util.List;

public interface TestPaperDao {

    /**
     * 查询所有试卷的方法
     * @return
     */
    public List<ETestpaper> findAllTestPaper();

    public List<ETestpaper> findtestPaperBySubjectId(Integer subjectId);
}
