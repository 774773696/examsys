package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ESessionMangeDao;
import com.qfedu.examsys.dao.SubjectDao;
import com.qfedu.examsys.dao.TestPaperDao;
import com.qfedu.examsys.pojo.ESessionMange;
import com.qfedu.examsys.pojo.ESubject;
import com.qfedu.examsys.pojo.ETestpaper;
import com.qfedu.examsys.service.ESessionMangeService;
import com.qfedu.examsys.service.TestPaperService;
import com.qfedu.examsys.vo.ESmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/15 9:48
 */
@Service
public class ESessionMangeServiceImpl implements ESessionMangeService {

    @Autowired(required = false)
    private ESessionMangeDao eSessionMangeDao;

    @Autowired(required = false)
    private SubjectDao subjectDao;

    @Autowired(required = false)
    private TestPaperDao testPaperDao;

    @Autowired
    private TestPaperService testPaperService;


    @Override
    public List<ESmVo> findAllSessionMangeByPage(Integer page, Integer limit, String tpTitle, Date smBeginTime, String subjectName) {

        PageHelper.startPage(page, limit);
        return eSessionMangeDao.findAllSessionMange(tpTitle, smBeginTime,subjectName);
    }

    @Override
    public ESmVo findSessionMangeById(Integer smid) {
        return eSessionMangeDao.findSessionmangeById(smid);
    }

    @Override
    public void deleteSessionMange(Integer[] smids) {
        eSessionMangeDao.deleteSessionMange(smids);
    }

    @Override
    public void deleteSessionMangeById(Integer smid) {
        eSessionMangeDao.deleteSessionMangeById(smid);
    }

    @Override
    public void modifySessionMange(ESessionMange eSessionMange) {
            eSessionMangeDao.modifySessionMange(eSessionMange);
    }

    @Override
    public void addSessionMange(ESessionMange eSessionMange) {

        eSessionMangeDao.addSessionMange(eSessionMange);
    }

    @Override
    public List<Map<String, Object>> groupSessionType() {
        List<ESubject> subjects = subjectDao.findAllSubject();
        List<Map<String,Object>> list = new ArrayList<>();
        for (ESubject eSubject : subjects) {
            List<ETestpaper> list_testpaper = testPaperService.findtestPaperBySubjectId(eSubject.getsubjectId());
            Map<String,Object> map = new HashMap<>();
            map.put("eSubject",eSubject);
            map.put("testpaper", list_testpaper);
            list.add(map);
        }
        return list;

    }
}
