package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.SubjectDao;
import com.qfedu.examsys.pojo.ESubject;
import com.qfedu.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/17 10:41
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired(required = false)
    private SubjectDao subjectDao;

    @Override
    public List<ESubject> fianAllSubject() {
        return subjectDao.findAllSubject();
    }
}
