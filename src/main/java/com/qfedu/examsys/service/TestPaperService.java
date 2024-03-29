package com.qfedu.examsys.service;

import com.qfedu.examsys.pojo.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TestPaperService {
    //查询所有试题的科目
    public List<ESubject> findAllSubject();

    public void importSinglequestions();

    //查询所有的单选题目

    public List<ESinglequestions> findAllSingleQuestions(Integer page,Integer limit);
    //查询所有的单选题目
    public List<EYnquestions> findAllYnquestions(Integer page, Integer limit);
    //查询所有的多选题目
    public List<EMulquestions> findAllMulquestions(Integer page, Integer limit);
    //查询所有的简答题目
    public List<EAnswerquestions> findAllAnswerquestions(Integer page, Integer limit);

    /**
     * 通过科目id查询对应的试卷
     * @param subjectId
     * @return
     */
    public List<ETestpaper> findtestPaperBySubjectId(Integer subjectId);

    /**
     * 查询所有试卷
     * @return
     */
    public List<ETestpaper> findAllTestPaper();



    public void delAnswerquestions(int aqId);


    public void delMulquestions(int mqId);
    public void delSingleQuestions(int sqId);

    public void delYnquestions(int yqId);


    public void uploadSingleQuestion(MultipartFile file);



    public void updateSingleQuestions(ESinglequestions singlequestions);

    public EAnswerquestions updateAnswerquestions(int aqId);

    public EMulquestions updateMulquestions(int mqId);

    public EYnquestions updateYnquestions(int yqId);
}
