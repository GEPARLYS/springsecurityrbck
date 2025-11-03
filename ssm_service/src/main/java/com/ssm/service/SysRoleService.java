package com.ssm.service;

import com.ssm.domain.SysRole;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 19:53
 * @Version 1.0
 */
public interface SysRoleService {
    List<SysRole> roleList();

    List<SysRole> getList();
}
