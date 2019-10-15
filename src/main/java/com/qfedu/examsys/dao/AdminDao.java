package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.EAdmin;
import com.qfedu.examsys.pojo.MenuInfo;

import java.util.List;

public interface AdminDao{

    //根据名字查询管理员
    public EAdmin findByAdminName(String name);


    // 根据id获取菜单信息
    public List<MenuInfo>findMenu(Integer id);


    //获得登录用户的权限信息的列表
    public List<String> findPermsByName(String name);

}
