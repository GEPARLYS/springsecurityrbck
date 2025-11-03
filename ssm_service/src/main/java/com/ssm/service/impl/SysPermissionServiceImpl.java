package com.ssm.service.impl;

import com.ssm.dao.SysPermissionDao;
import com.ssm.domain.SysPermission;
import com.ssm.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 20:13
 * @Version 1.0
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Override
    public List<SysPermission> getList() {
        List<SysPermission> pList = sysPermissionDao.getList();
        return pList;
    }

    @Override
    public int add(SysPermission sysPermission) {
       int count = sysPermissionDao.add(sysPermission);
        return count;
    }
}
