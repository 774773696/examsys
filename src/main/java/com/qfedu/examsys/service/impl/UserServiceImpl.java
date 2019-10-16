package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.UserDao;
import com.qfedu.examsys.pojo.EUser;
import com.qfedu.examsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李冠凯.
 * @Description
 * @date 2019/10/14.
 * @time 19:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public EUser login(String name, String password) {

        EUser user = userDao.findByName(name);

        if (user == null) {
            throw new RuntimeException("用户不存在");
        } else {
            if (!password.equals(user.getUname())) {
                throw new RuntimeException("密码错误");
            } else {
                return user;
            }
        }

    }

    @Override
    public List<EUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public EUser findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void add(EUser eUser) {

        EUser user = userDao.findByName(eUser.getUname());

        if (user != null) {
            throw new RuntimeException("存在同名用户，不能添加");
        }

        userDao.add(eUser);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void update(EUser eUser) {
        userDao.update(eUser);
    }
}
