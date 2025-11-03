package com.ssm.service;

import com.ssm.domain.SysPermission;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 20:13
 * @Version 1.0
 */
public interface SysPermissionService {
    List<SysPermission> getList();

    int add(SysPermission sysPermission);
}
