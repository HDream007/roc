package com.rimi.roc.service;

import com.rimi.roc.pojo.CourseCategory;

import java.util.List;

/**
 * @author 惜-梦
 * @description
 * @date 2019-02-22 14:32
 */
public interface ICourseCategoryService {
   List<CourseCategory> findAll();
   boolean insertDate(String msg);
   List<CourseCategory> find();
}
