package com.qfedu.examsys.dao;

import com.qfedu.examsys.pojo.EAdmin;
import com.qfedu.examsys.pojo.EPermission;
import com.qfedu.examsys.pojo.MenuInfo;

import java.util.List;

public interface AdminDao{

    //根据名字查询管理员
    public EAdmin findByAdminName(String name);


    // 根据id获取菜单信息
    public List<MenuInfo>findMenu(Integer id);


    //获得登录用户的权限信息的列表
    public List<String> findPermsByName(String name);


    //添加admin用户
    public void addAdmin(EAdmin admin);


    //模糊查询遍历所有权限
    public List<EPermission> findAllPerm(String pname);

    //增加权限信息
    public void add(EPermission ePermission);

    //删除权限信息
    public void delete(Integer pid);

    //修改权限信息
    public void update(EPermission ePermission);

    //根据权限id查找权限
    public EPermission findByPermId(Integer pid);
}
