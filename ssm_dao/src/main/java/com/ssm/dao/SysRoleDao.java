package com.ssm.dao;

import com.ssm.domain.SysRole;
import org.apache.ibatis.annotations.*;
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

//    @Select("select * from sys_user_role sur,sys_role sr where sur.userid=sr.id and id = #{id}")
//    @Results(
//            @Result(property = "permissions",column = "roles",
//            many = @Many(select = "com.ssm.dao.SysPermissionDao.getByRoleIds",fetchType = FetchType.LAZY))
//    )

    
    @Select("SELECT r.* FROM sys_role r INNER JOIN sys_user_role ur on r.id = ur.roleid where ur.userid = #{userid}")
    List<SysRole> getByUserId(@Param("userId") Integer id);



    @Select("select * from sys_user_role sur,sys_role sr where sur.roleid=sr.id and userid = #{id}")
    @Results(
            @Result(property = "permissions",column = "roles",
                    many = @Many(select = "com.ssm.dao.SysPermissionDao.getByRoleIds",fetchType = FetchType.LAZY))
    )
    List<SysRole> getByUserIdGetRoleList(Integer id);
}
