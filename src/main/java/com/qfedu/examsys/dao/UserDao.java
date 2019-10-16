package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.EUser;

import java.util.List;

/**
 * 用于后台的增删改查和前台的登录注册
 * @author 李冠凯.
 * @Description
 * @date 2019/10/14.
 * @time 17:36
 */
public interface UserDao {

    /**
     * 查询所有的普通用户
     * @return
     */
    List<EUser> findAll();

    /**
     * 根据uid查询单个用户
     * @param uid
     *      用户id
     * @return
     */
    EUser findById(Integer uid);

    /**
     * 根据uanem查询用户 登陆时使用
     * @param uname
     * @return
     */
    EUser findByName(String uname);

    /**
     * 增加普通用户
     * 既可以在后台管理用户时使用
     * 也可以在前台注册新用户时使用
     * @param eUser
     */
    void add(EUser eUser);

    /**
     * 根据id删除用户
     * @param uid
     */
    void delete(Integer uid);

    /**
     * 更新用户信息
     * @param eUser
     */
    void update(EUser eUser);
}
