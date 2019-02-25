package com.rimi.roc.mapper;

import com.rimi.roc.commons.MyMapper;
import com.rimi.roc.pojo.CourseCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 惜-梦
 * @description
 * @date 2019-02-22 14:29
 */
public interface ICourseCategoryMapper extends MyMapper<CourseCategory> {

    List<CourseCategory> find();

}
