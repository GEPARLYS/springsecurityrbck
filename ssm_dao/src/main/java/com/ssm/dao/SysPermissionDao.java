package com.ssm.dao;

import com.ssm.domain.SysPermission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 20:15
 * @Version 1.0
 */
public interface SysPermissionDao {

    @Select("select * from sys_permission")
    List<SysPermission> getList();

    @Insert("insert into sys_permission(id,permissionName,url,pid) values (sys_permission_seq.nextval,#{permissionName},#{url},#{pid})")
    int add(SysPermission sysPermission);

//    @Select("select * from sys_role_permission srp,sys_permission sp where srp.permissionid = sp.id and srp.roleid = #{id}")
@Select({
        "<script>",
        "SELECT sp.* FROM sys_role_permission srp, sys_permission sp",
        "WHERE srp.permissionid = sp.id",
        "AND srp.roleid IN",
        "<foreach collection='roleIds' item='roleId' open='(' separator=',' close=')'>",
        "   #{roleId}",
        "</foreach>",
        "</script>"
})
    List<SysPermission> getByRoleIds(@Param("roleIds") Integer id);
}
