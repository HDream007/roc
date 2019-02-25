package com.rimi.roc.service.impl;

import com.rimi.roc.mapper.ICourseCategoryMapper;
import com.rimi.roc.pojo.CourseCategory;
import com.rimi.roc.service.ICourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 惜-梦
 * @description
 * @date 2019-02-22 14:32
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class CourseCategoryServiceImpl implements ICourseCategoryService {

    private final ICourseCategoryMapper mapper;

    public CourseCategoryServiceImpl(ICourseCategoryMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<CourseCategory> findAll() {
        return mapper.selectAll();
    }

    @Override
    public boolean insertDate(String msg) {
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setName(msg);
        int i = mapper.insert(courseCategory);
        if (i<0){
            return false;
        }
        return true ;
    }

    @Override
    public List<CourseCategory> find() {
        return mapper.find();
    }
}
