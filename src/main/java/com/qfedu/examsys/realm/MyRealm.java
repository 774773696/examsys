package com.qfedu.examsys.realm;

import com.qfedu.examsys.pojo.EAdmin;
import com.qfedu.examsys.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;


public class MyRealm extends AuthorizingRealm {




    @Autowired(required = false)
    @Lazy    // 使用redis缓存shiro中数据时，需要使用该注解 （懒加载）
    private AdminService adminService;

    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 获取合法登录用户的用户名
        String name = (String) principalCollection.getPrimaryPrincipal();

        // 查询拥有的权限
        List<String> permsList = adminService.findPermsByName(name);

        //创建授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //设置权限
        info.setStringPermissions(new HashSet<>(permsList));


        return info;

    }


    //获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户的身份信息
        String name = (String) authenticationToken.getPrincipal();
        EAdmin admin = adminService.login(name);

        SimpleAuthenticationInfo info = null;

        if (admin == null){

            info = new SimpleAuthenticationInfo("","",this.getName());


        }else{
            //身份认证信息对象
            //第一个参数：用户身份信息 用户名
            //第二个参数：用户凭证信息 密码
            //第三个参数：realm的名称
         //   info = new SimpleAuthenticationInfo(name,user.getPassword(),this.getName());

            //如果md5中使用盐值，需要在认证信息对象设置盐值
            info = new SimpleAuthenticationInfo(name,admin.getApassword(),ByteSource.Util.bytes("haha"),this.getName());
            SecurityUtils.getSubject().getSession().setTimeout(-1000L);
        }


        return info;

    }

    public static void main(String[] args) {

        SimpleHash simpleHash = new SimpleHash("md5", "123", "haha", 1);

        System.out.println(simpleHash.toHex());//转换成16进制值打印输出

    }


}
