package com.qfedu.examsys.service;

import com.qfedu.examsys.pojo.EAdmin;
import com.qfedu.examsys.pojo.EPermission;
import com.qfedu.examsys.pojo.MenuInfo;

import java.util.List;

public interface AdminService {

    // Admin用户注册
    public void register(EAdmin admin);

    // Admin用户登录
    public EAdmin login(String name);


    // 根据id获取菜单信息
    public List<MenuInfo>findMenu(Integer id);


    //获得登录用户的权限信息的列表
    public List<String> findPermsByName(String name);


    //模糊查询遍历所有权限
    public List<EPermission> findAllPerm(String pname,Integer page, Integer limit);


    //增加权限信息
    public void add(EPermission ePermission);

    //删除权限信息
    public void delete(Integer pid);

    //修改权限信息
    public void update(EPermission ePermission);

}
