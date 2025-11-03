package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Orders;
import com.ssm.domain.SysLog;


/**
 * @Author j
 * @Date 2019/9/10 15:04
 * @Version 1.0
 */
public interface SysLogService {
    void addLog(SysLog sysLog);


    PageInfo<SysLog> pageList(int page, int size);
}
