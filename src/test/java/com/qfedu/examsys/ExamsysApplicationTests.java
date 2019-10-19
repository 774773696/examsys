package com.qfedu.examsys;

import com.qfedu.examsys.dao.AdminDao;
import com.qfedu.examsys.pojo.EPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamsysApplicationTests {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testfindAllPerm(){

        String pname = null;
        List<EPermission> list = adminDao.findAllPerm(pname);

        for (EPermission p : list){
            System.out.println(p.getPname());
        }

    }

    @Test
    public void testAdd(){

        EPermission e = new EPermission();
        e.setPid(25);
        e.setPname("所有权限");
        e.setPdesc("exam:all");
        e.setType(1);
        e.setUrl("bais");
        adminDao.add(e);



    }

}
