package com.qfedu.examsys.service;

import com.qfedu.examsys.pojo.EUser;

import java.util.List;

/**
 * @author 李冠凯.
 * @Description
 * @date 2019/10/14.
 * @time 19:02
 */
public interface UserService {

    /**
     * 登陆功能
     * @param name
     * @param password
     * @return
     */
    EUser login(String name, String password);

    /**
     * 查询所有
     * @return
     */
    List<EUser> findAll(Integer page, Integer limit);

    /**
     * 修改信息前查询该用户
     * @param id
     * @return
     */
    EUser findById(Integer id);

    EUser findByNumber(String number);

    /**
     * 增加用户 注册用户
     * @param eUser
     */
    void add(EUser eUser);

    /**
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新用户信息
     * @param eUser
     */
    void update(EUser eUser);

    /**
     * 获取到所有的专业
     * @return
     */
    List<String> findAllProfession();

    List<EUser> findByCondition(String unumber, String uname, String uprofession, Integer page, Integer limit);
}
