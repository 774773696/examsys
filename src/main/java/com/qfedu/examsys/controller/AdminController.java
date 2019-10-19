package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.EAdmin;
import com.qfedu.examsys.pojo.EPermission;
import com.qfedu.examsys.pojo.MenuInfo;
import com.qfedu.examsys.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {


    @Autowired(required = false)
    private AdminService adminService;


    @PostMapping("/login.do")
    @ResponseBody
    public JsonBean login(String name,String password,HttpSession session){

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        Subject subject = SecurityUtils.getSubject();


        try {
            //登录判断
            subject.login(token);
            EAdmin login = adminService.login(name);
            session.setAttribute("user",login);
        } catch (Exception e) {
            return new JsonBean(1,"用户名或密码错误");
        }

        return new JsonBean(0,"登录成功");

    }


    @PostMapping("/register.do")
    @ResponseBody
    public JsonBean register(EAdmin admin){

        if (admin != null){
            SimpleHash simpleHash = new SimpleHash("md5", admin.getApassword(), "haha", 1);

            admin.setApassword(simpleHash.toString());

            adminService.register(admin);

            return new JsonBean(0,"注册成功");
        }

        return new JsonBean(1,"注册失败");

    }

    @RequestMapping("/findMenu.do")
    @ResponseBody
    public JsonBean findMenu(HttpSession session){



        EAdmin admin = (EAdmin) session.getAttribute("user");

        List<MenuInfo> menu = adminService.findMenu(admin.getAid());


        return new JsonBean(0,menu);

    }


    @RequestMapping("/list.do")
    @ResponseBody
    public Map findAllPerm(String pname, Integer page, Integer limit){

        List<EPermission> list = adminService.findAllPerm(pname, page, limit);

        long total = ((Page) list).getTotal();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public JsonBean addPerm(EPermission ePermission){

        adminService.add(ePermission);

        return new JsonBean(0,"添加成功");
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public JsonBean deletePerm(Integer pid){
        adminService.delete(pid);

        return new JsonBean(0,"删除成功");
    }


    @RequestMapping("/update.do")
    @ResponseBody
    public JsonBean updatePerm(EPermission ePermission){
        adminService.update(ePermission);
        return new JsonBean(0,"修改成功");
    }


}
