package com.ssm.dao;

import com.ssm.domain.SysRole;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 19:56
 * @Version 1.0
 */
public interface SysRoleDao {

    @Select("select * from sys_role")
    List<SysRole> getList();

    @Select("select * from sys_user_role sur,sys_role sr where sur.userid=sr.id and id = #{id}")
    @Results(
            @Result(property = "permissions",column = "roles",
            many = @Many(select = "com.ssm.dao.SysPermissionDao.getByRoleId",fetchType = FetchType.LAZY))
    )
    List<SysRole> getByUserId(Integer id);



    @Select("select * from sys_user_role sur,sys_role sr where sur.roleid=sr.id and userid = #{id}")
    @Results(
            @Result(property = "permissions",column = "roles",
                    many = @Many(select = "com.ssm.dao.SysPermissionDao.getByRoleIds",fetchType = FetchType.LAZY))
    )
    List<SysRole> getByUserIdGetRoleList(Integer id);
}
