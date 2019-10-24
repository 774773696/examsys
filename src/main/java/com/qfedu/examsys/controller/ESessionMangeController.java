package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.dao.TestPaperDao;
import com.qfedu.examsys.pojo.ESessionMange;
import com.qfedu.examsys.pojo.ETestpaper;
import com.qfedu.examsys.service.ESessionMangeService;
import com.qfedu.examsys.vo.ESmVo;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/15 11:20
 * 考试场次管理控制类
 */
@RestController
public class ESessionMangeController {

    @Autowired
    private ESessionMangeService eSessionMangeService;

    @Autowired(required = false)
    private TestPaperDao testPaperDao;

    @RequestMapping("/smList.do")
    public Map<String, Object> findAllSessionMange(Integer page, Integer limit, String tpTitle, Date smBeginTime, String subjectName) {
        List<ESmVo> list = eSessionMangeService.findAllSessionMangeByPage(page, limit,tpTitle, smBeginTime,subjectName);
        long total = ((Page) list).getTotal();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;


    }

    @RequestMapping("findsmone.do")
    public JsonBean findSessionmangeById(Integer smid) {

        ESmVo eSmVo = eSessionMangeService.findSessionMangeById(smid);
        return new JsonBean(0, eSmVo);
    }

    @RequestMapping("/deletesm.do")
    public JsonBean deleteSessionMange(Integer[] smids) {
        System.out.println(smids);
        eSessionMangeService.deleteSessionMange(smids);
        return new JsonBean(0, null);
    }

    @RequestMapping("/deletesmone.do")
    public JsonBean deleteSessionMangeById(Integer smid) {
         eSessionMangeService.deleteSessionMangeById(smid);
        return new JsonBean(0, null);
    }

    @RequestMapping("/modifySessionMange.do")
    public JsonBean modifySessionMange(ESessionMange eSessionMange) {
        Date betinTime = eSessionMange.getSmBeginTime();
        Date endTime = eSessionMange.getSmEndTime();
        // betinTime.after(endTime),当betinTime大于endTime时，返回TRUE，
        // 当小于等于时，返回false；
        if (betinTime.after(endTime) == true) {
            return new JsonBean(1,"结束时间不能小于开始时间");
        }
           eSessionMangeService.modifySessionMange(eSessionMange);
        return new JsonBean(0, "修改成功");
    }

    @RequestMapping("/addSessionMange.do")
    public JsonBean addSessionMange(ESessionMange eSessionMange) {
        Date betinTime = eSessionMange.getSmBeginTime();
        Date endTime = eSessionMange.getSmEndTime();
        // betinTime.after(endTime),当betinTime大于endTime时，返回TRUE，
        // 当小于等于时，返回false；
        if (betinTime.after(endTime) == true) {
            return new JsonBean(1,"结束时间不能小于开始时间");
        }
        eSessionMangeService.addSessionMange(eSessionMange);
        return new JsonBean(0, null);
    }

    /**
     * 添加场次时显示科目的二级联动菜单
     */
    @RequestMapping("/subjectmenu.do")
    public JsonBean findSubjectMenu() {
        List<Map<String, Object>> list = eSessionMangeService.groupSessionType();
        Map<String, Object> map = new HashMap<>();
        map.put("group", list);
        return new JsonBean(0, map);

    }
}
