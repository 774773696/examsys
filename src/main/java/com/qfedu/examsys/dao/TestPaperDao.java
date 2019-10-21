package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.*;

import java.util.List;

public interface TestPaperDao {

    /**
     * 查询所有试卷的方法
     *
     * @return
     */
    public List<ETestpaper> findAllTestPaper();

    /**
     * 根据科目id查询试卷的方法
     *
     * @param subjectId
     * @return
     */
    public List<ETestpaper> findtestPaperBySubjectId(Integer subjectId);

    /**
     * 导入单选题的方法
     */
    public void addSingleQuestions(List<ESinglequestions> list);

    /**
     * 导入多选题的方法
     * @param list
     */
    public void addMulQuestions(List<EMulquestions> list);

    /**
     * 导入简答题的方法
     * @param list
     */
    public void addAnswerQustions(List<EAnswerquestions> list);

    /**
     * 导入填空题题的方法
     * @param list
     */
    public void addFillQuestion(List<EFillquestions> list);

    /**
     * 添加判断题的方法
     * @param list
     */
    public void addYnQuestion(List<EYnquestions> list);

}
