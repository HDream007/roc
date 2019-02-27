package com.rimi.roc.pojo;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author 惜-梦
 * @description 管理员
 * @date 2019-02-27 16:16
 */
@Data
public class Admin {

    @Id
    private Long id;
    private String username;
    private String password;
    private Boolean super_admin;


    public Long getId() {
        return id;
    }

    public Admin setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Admin setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getSuper_admin() {
        return super_admin;
    }

    public Admin setSuper_admin(Boolean super_admin) {
        this.super_admin = super_admin;
        return this;
    }
}
