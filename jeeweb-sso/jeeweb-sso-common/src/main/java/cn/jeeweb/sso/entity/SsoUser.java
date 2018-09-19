package cn.jeeweb.sso.entity;


import java.io.Serializable;
import java.util.Set;

/**
 * Created by hexin on 2018/9/17.
 */
public class SsoUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 是否锁定（1：正常；-1：删除；0：锁定；）
     */
    public static final String STATUS_DELETE = "-1";
    public static final String STATUS_LOCKED = "0";
    public static final String STATUS_NORMAL = "1";

    private String id;
    // 姓名
    private String username;
    // 用户名
    private String realname;
    // 头像
    private String portrait;
    // 邮件
    private String email;
    // 联系电话
    private String phone;
    //系统用户的状态
    private String status = STATUS_NORMAL;

    private Set<String> roles;
    private Set<String> permissions;

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
