package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonBean;
import com.qfedu.examsys.pojo.EUser;
import com.qfedu.examsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 李冠凯.
 * @Description
 * @date 2019/10/14.
 * @time 19:12
 */
@Controller
//@RequestMapping("/user")
@ResponseBody
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
    public JsonBean findAll() {
        List<EUser> users = userService.findAll();

        return new JsonBean(0, users);
    }

    @RequestMapping("/delete")
    public JsonBean delete(Integer id) {

        userService.delete(id);

        return new JsonBean(0, null);

    }

    @RequestMapping("/query")
    public JsonBean<EUser> queryById(Integer id) {
        EUser user = userService.findById(id);

        return new JsonBean(0, user);
    }

    @RequestMapping("/update")
    public JsonBean update(EUser eUser) {
        userService.update(eUser);

        return new JsonBean(0, null);
    }
}
