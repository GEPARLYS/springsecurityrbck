package com.ssm.domain;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 17:53
 * @Version 1.0
 */
public class SysUser {
    private Long id; // 用户编号，主键
    private String username;// 登陆用户名
    private String email;// 邮件地址
    private String password;// 密码
    private String phoneNum;// 手机号码
    private int status;// 用户的状态：0：禁用，1：启用

    private List<SysRole> roles;// 用户所拥有的角色


    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
