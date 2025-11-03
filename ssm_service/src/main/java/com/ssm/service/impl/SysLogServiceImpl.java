package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.SysLogDao;
import com.ssm.domain.Orders;
import com.ssm.domain.SysLog;
import com.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/10 15:05
 * @Version 1.0
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void addLog(SysLog sysLog) {
        sysLogDao.addLog(sysLog);
    }

    @Override
    public PageInfo<SysLog> pageList(int page, int size) {
        //第一个参数是开始的行号
        //第二个参数是获取的记录数
        PageHelper.startPage(page, size);
        //查询所有
        List<SysLog> list    = sysLogDao.list();
        //根据查询结果创建分页信息并且返回
        PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(list);
        return pageInfo;
    }


}
