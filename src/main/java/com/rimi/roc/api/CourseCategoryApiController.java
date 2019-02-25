package com.rimi.roc.api;

import com.rimi.roc.commons.RestVo;
import com.rimi.roc.pojo.CourseCategory;
import com.rimi.roc.service.ICourseCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 惜-梦
 * @description 课程类别API
 * @date 2019-02-21 16:17
 */

@Api(tags = "课程类别API", description = "课程相关的接口")
@RestController
public class CourseCategoryApiController {


    private final ICourseCategoryService courseCategoryService;

    @Autowired
    public CourseCategoryApiController(ICourseCategoryService courseCategoryService) {
        this.courseCategoryService = courseCategoryService;
    }

    @ApiOperation("请求分类列表")
    @GetMapping("/Coursecategory")
    public RestVo getCourseCategory() {
        List<CourseCategory> courseCategories = courseCategoryService.find();
//        boolean b = courseCategoryService.insertDate("zhangsan");
        return new RestVo.Builder().success().data(courseCategories).build();
    }




}
