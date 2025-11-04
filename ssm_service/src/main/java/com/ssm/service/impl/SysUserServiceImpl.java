package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.SysUserDao;
import com.ssm.domain.SysRole;
import com.ssm.domain.SysUser;
import com.ssm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 17:29
 * @Version 1.0
 */
@Service("userService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        //登录数据库认证 要求:用户名必须唯一
        SysUser sysUser = sysUserDao.findByUsername(username);
        if (sysUser != null){
            //设置假的权限
            List<GrantedAuthority> authorities = new ArrayList<>();
            //获取用户名角色
            List<SysRole> roles = sysUser.getRoles();
                for (SysRole role : roles) {
                //存入角色
                authorities.add(new SimpleGrantedAuthority(role.getRoleDesc())); //TODO 角色名要跟配置相对应
            }
            //<security:intercept-url pattern="/**" access="ROLE_USER" />
            // 创建一个权限信息
            // spring security 规范好了的登陆用户信息
            // {noop}让security不要加密

            //创建用户
           
            return new User(username, sysUser.getPassword(), authorities);
        }


        return null;
    }

    @Override
    public PageInfo<SysUser> pageList(int page, int size) {
        PageHelper.startPage(page,size);
        List<SysUser> users = sysUserDao.pageList();

        return new PageInfo<>(users);
    }

    @Override
    public int add(SysUser sysUser) {
        sysUser.setPassword(encoder.encode(sysUser.getPassword()));
        return sysUserDao.add(sysUser);
    }

    @Override
    public SysUser getById(Integer id) {
        return sysUserDao.getById(id);
    }

    @Override
    public int updateRoles(Integer userId, List<Integer> ids) {
        int count = sysUserDao.deleteUserRole(userId);
        if (ids != null && !ids.isEmpty()){
            for (Integer roleId : ids) {
                count += sysUserDao.addUserRole(userId,roleId);
            }
        }

        return count;
    }

    
    
}


