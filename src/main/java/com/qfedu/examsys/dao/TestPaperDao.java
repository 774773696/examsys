package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.ESinglequestions;
import com.qfedu.examsys.pojo.ETestpaper;

import java.util.List;

public interface TestPaperDao {

    /**
     * 查询所有试卷的方法
     * @return
     */
    public List<ETestpaper> findAllTestPaper();

    /**
     * 根据科目id查询试卷的方法
     * @param subjectId
     * @return
     */
    public List<ETestpaper> findtestPaperBySubjectId(Integer subjectId);

    /**
     * 导入单选题的方法
     */
    public void addSingleQuestions(List<ESinglequestions> list);


}
