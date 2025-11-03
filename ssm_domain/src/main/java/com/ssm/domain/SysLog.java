package com.ssm.domain;

import java.util.Date;

/**
 * @Author j
 * @Date 2019/9/10 14:58
 * @Version 1.0
 */
public class SysLog {

    private Long id;
    private Date visitTime;
    private String username;
    private String ip;
    private String method;

    public SysLog() {
    }

    public SysLog(Long id, Date visitTime, String username, String ip, String method) {
        this.id = id;
        this.visitTime = visitTime;
        this.username = username;
        this.ip = ip;
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
