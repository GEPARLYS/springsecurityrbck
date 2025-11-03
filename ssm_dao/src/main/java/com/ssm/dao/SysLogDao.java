package com.ssm.dao;

import com.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/10 15:20
 * @Version 1.0
 */
public interface SysLogDao {
    @Insert("insert into sys_log values(log_seq.nextval,#{visitTime},#{username},#{ip},#{method})")
    void addLog(SysLog sysLog);

    @Select("select * from sys_log")
    List<SysLog> list();

}
