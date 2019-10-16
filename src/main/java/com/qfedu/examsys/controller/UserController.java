package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.EUser;
import com.qfedu.examsys.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李冠凯.
 * @Description
 * @date 2019/10/14.
 * @time 19:12
 */
@CrossOrigin
@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("/login")
    public JsonBean login(String name, String password) {

        EUser user = userService.login(name, password);

        return new JsonBean(0, user);

    }

    @RequestMapping("/register")
    public JsonBean register(EUser eUser) {
        try {
            userService.add(eUser);
            return new JsonBean(0, null);
        } catch (Exception e) {
            return new JsonBean(1, e.getMessage());
        }
    }

    @RequestMapping("/list")
    public Map<String, Object> findAll(Integer page, Integer limit) {
        HashMap<String, Object> map = new HashMap<>();

        List<EUser> list = userService.findAll(page, limit);

        map.put("code", 0);
        map.put("count", ((Page)list).getTotal());
        map.put("data", list);

        return map;
    }

    @RequestMapping("/delete")
    public JsonBean delete(@Param("id") Integer id) {

        userService.delete(id);

        return new JsonBean(0, null);

    }

    @RequestMapping("/query")
    public JsonBean<EUser> queryById(Integer uid) {
        EUser user = userService.findById(uid);

        return new JsonBean(0, user);
    }


    @RequestMapping("/query2")
    public JsonBean<EUser> queryByNumber(String unumber) {
        EUser user = userService.findByNumber(unumber);

        return new JsonBean(0, user);
    }

    @RequestMapping("/update")
    public JsonBean update(EUser eUser) {
        userService.update(eUser);

        return new JsonBean(0, null);
    }


    @RequestMapping("/condition")
    public JsonBean findByCondition(@Param("unumber") String unumber, @Param("uname") String uname, @Param("uprofession") String uprofession, Integer page, Integer limit) {

        List<EUser> list = userService.findByCondition(unumber, uname, uprofession, page, limit);

        return new JsonBean(0, list);
    }
}
