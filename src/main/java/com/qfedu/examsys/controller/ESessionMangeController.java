package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.service.ESessionMangeService;
import com.qfedu.examsys.vo.ESmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@CrossOrigin
@Controller
@ResponseBody
public class ESessionMangeController {

    @Autowired
    private ESessionMangeService eSessionMangeService;

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

    @RequestMapping("/deletesm.do")
    public JsonBean deleteSessionMange(int[] smids) {
        eSessionMangeService.deleteSessionMange(smids);
        return new JsonBean(0, null);
    }

    @RequestMapping("/deletesmone.do")
    public JsonBean deleteSessionMangeById(Integer smid) {
         eSessionMangeService.deleteSessionMangeById(smid);
        return new JsonBean(0, null);
    }

    @RequestMapping("/modifySessionMange.do")
    public JsonBean modifySessionMange(Integer smid) {
            if (smid == null) {
                return new JsonBean(1, "考试场次不存在");
            }
        ESmVo mange = eSessionMangeService.findSessionMangeById(smid);
            if (mange != null) {
                eSessionMangeService.modifySessionMange(mange);
    }
        return new JsonBean(0, "修改成功");
    }

    @RequestMapping("/addSessionMange.do")
    public JsonBean addSessionMange(ESmVo eSmVo) {
        eSessionMangeService.addSessionMange(eSmVo);
        return new JsonBean(0, null);
    }
}