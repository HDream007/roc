package com.rimi.roc.pojo;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author 惜-梦
 * @description 权限
 * @date 2019-02-27 16:29
 */
@Data
public class Permission {
    @Id
    private Long id;
    private String name;
    /**
     * 权限表达式
     */
    private String expression;


    public Long getId() {
        return id;
    }

    public Permission setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getExpression() {
        return expression;
    }

    public Permission setExpression(String expression) {
        this.expression = expression;
        return this;
    }
}
