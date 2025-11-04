package com.ssm.dao;

import com.ssm.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 17:55
 * @Version 1.0
 */
public interface SysUserDao {
    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",
                    many = @Many(select = "com.ssm.dao.SysRoleDao.getByUserId"))
    })
    SysUser findByUsername(String username);

    @Select("select * from sys_user")
    List<SysUser> pageList();

    @Insert("insert into sys_user(id,username,email,password,phonenum,status)values(user_seq.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    int add(SysUser sysUser);

    @Select("select * from sys_user where id = #{id}")
    @Results(
            id="myResult",// 给result取一个ID
            value={
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "id", property = "roles", many = @Many(select = "com.ssm.dao.SysRoleDao.getByUserIdGetRoleList",fetchType = FetchType.LAZY))
            })
    SysUser getById(Integer id);

    @Delete("delete from sys_user_role where userid=#{userId}")
    int deleteUserRole(Integer userId);

    @Insert("insert into sys_user_role(userid,roleid)values(#{userId},#{roleId})")
    int addUserRole(@Param(value = "userId") Integer userId, @Param(value = "roleId") Integer roleId);


}
