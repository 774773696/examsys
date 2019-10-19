package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.AdminDao;
import com.qfedu.examsys.pojo.EAdmin;
import com.qfedu.examsys.pojo.EPermission;
import com.qfedu.examsys.pojo.MenuInfo;
import com.qfedu.examsys.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//用在类上，设置缓存的名称
@CacheConfig(cacheNames = "admin")
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;



    @Override
    public void register(EAdmin admin) {

        adminDao.addAdmin(admin);
    }

    @Override
    public EAdmin login(String name) {

        EAdmin admin = null;
        try {
            admin = adminDao.findByAdminName(name);
        } catch (Exception e) {

            throw new RuntimeException("用户名错误");
        }


        return admin;
    }

    @Override
    public List<MenuInfo> findMenu(Integer id) {

        List<MenuInfo> menu = adminDao.findMenu(id);

        return menu;
    }




    @Override
    //进行缓存，缓存方法的返回值
    @Cacheable(key = "'perms'.concat(#name)")
    public List<String> findPermsByName(String name) {


        List<String> list = adminDao.findPermsByName(name);

        return list;
    }

    @Override
    public List<EPermission> findAllPerm(String pname, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<EPermission> list = adminDao.findAllPerm(pname);

        return list;
    }

    @Override
    public void add(EPermission ePermission) {

        adminDao.add(ePermission);
    }

    @Override
    public void delete(Integer pid) {
        adminDao.delete(pid);
    }

    @Override
    public void update(EPermission ePermission) {
        adminDao.update(ePermission);
    }
}
