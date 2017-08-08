package com.bwie.store1505d.model;

/**
 * Created by liqy on 2017/8/8.
 */

public class User {

    public int id;
    public String username;
    public String auth_key;
    public String password_hash;
    public String password_reset_token;
    public String email;
    public int status;
    public int created_at;
    public int updated_at;
    public String access_token;
    public String mobile;
    public String password_plain;
    public String updated_by;
    public String created_by;
    public String avatar;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", auth_key='" + auth_key + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", password_reset_token='" + password_reset_token + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", access_token='" + access_token + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password_plain='" + password_plain + '\'' +
                ", updated_by='" + updated_by + '\'' +
                ", created_by='" + created_by + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
