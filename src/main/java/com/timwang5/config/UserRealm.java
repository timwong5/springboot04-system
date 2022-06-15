package com.timwang5.config;

import com.timwang5.mapper.UserMapper;
import com.timwang5.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


@Configuration
public class UserRealm extends AuthorizingRealm {
    @Resource
    UserMapper userMapper;




    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();


        //拿出来user表中limits字段
        info.addStringPermission(currentUser.getLimits());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {//刚才的token是全局的，可以在这里取出认证
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userMapper.findLoginUserByName(token.getUsername());

        if(user == null){
            //用户名认证，用户名不同会自动抛出用户不存在异常
            return null;
        }

        System.out.println("认证方法执行了debug===>" + user.getLimits());
        //密码认证Shiro自己做,如果还需要设置权限授予，需要将user参数传递给SimpleAuthenticationInfo
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
