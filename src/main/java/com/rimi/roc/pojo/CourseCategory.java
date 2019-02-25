package com.rimi.roc.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author 惜-梦
 * @description
 * @date 2019-02-22 14:23
 */
public class CourseCategory {
    private Long id;
    private String name;
    private String icon;
    private String coverImage;
    private String introduction;
    private Integer priority;  //优先级
    private Date createTime;
    private CourseCategory parent;
    private List<CourseCategory> children;

    public Long getId() {
        return id;
    }

    public CourseCategory setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseCategory setName(String name) {
        this.name = name;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public CourseCategory setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public CourseCategory setCoverImage(String coverImage) {
        this.coverImage = coverImage;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public CourseCategory setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public CourseCategory setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public CourseCategory setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public CourseCategory getParent() {
        return parent;
    }

    public CourseCategory setParent(CourseCategory parent) {
        this.parent = parent;
        return this;
    }

    public List<CourseCategory> getChildren() {
        return children;
    }

    public CourseCategory setChildren(List<CourseCategory> children) {
        this.children = children;
        return this;
    }
}
