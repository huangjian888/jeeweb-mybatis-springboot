package com.company.manerger.sys.common.queue.entity;

import java.io.Serializable;

/**
 * 在线用户类
 */
public class OnlineUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String username;
    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
