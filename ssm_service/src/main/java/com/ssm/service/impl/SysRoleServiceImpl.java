package com.ssm.service.impl;

import com.ssm.dao.SysRoleDao;
import com.ssm.domain.SysRole;
import com.ssm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 19:54
 * @Version 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Override
    public List<SysRole> roleList() {
        List<SysRole> roleList = sysRoleDao.getList();
        return roleList;
    }

    @Override
    public List<SysRole> getList() {
        List<SysRole> list = sysRoleDao.getList();
        return list;
    }
}
