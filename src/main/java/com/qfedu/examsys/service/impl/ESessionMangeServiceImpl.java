package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ESessionMangeDao;
import com.qfedu.examsys.service.ESessionMangeService;
import com.qfedu.examsys.vo.ESmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/15 9:48
 */
@Service
public class ESessionMangeServiceImpl implements ESessionMangeService {

    @Autowired(required = false)
    private ESessionMangeDao eSessionMangeDao;


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
    public void modifySessionMange(ESmVo eSmVo) {
        eSessionMangeDao.modifySessionMange(eSmVo);
    }

    @Override
    public void addSessionMange(ESmVo eSmVo) {
        eSessionMangeDao.addSessionMange(eSmVo);
    }
}
