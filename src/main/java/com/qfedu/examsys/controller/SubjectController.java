package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.ESubject;
import com.qfedu.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/17 10:44
 */
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/subjectlist.do")
    public JsonBean findAllSubject() {

       List<ESubject> list = subjectService.fianAllSubject();

        return new JsonBean(0, list);
    }
}
