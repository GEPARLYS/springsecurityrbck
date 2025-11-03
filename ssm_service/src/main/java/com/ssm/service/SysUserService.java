package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 17:29
 * @Version 1.0
 */
public interface SysUserService extends UserDetailsService {
    PageInfo<SysUser> pageList(int page, int size);

    int add(SysUser sysUser);

    SysUser getById(Integer id);

    int updateRoles(Integer userId, List<Integer> ids);
}
