package com.rimi.roc.api;

import com.rimi.roc.commons.RestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 惜-梦
 * @description 课程
 * @date 2019-02-22 16:11
 */
@Api(tags = "课程API" ,description = "课程相关的接口")
@RestController
public class CourseApiController {

    @ApiOperation("请求分类列表")

    //字段说明
    @ApiImplicitParams({

            @ApiImplicitParam(name = "id",value = "ID",paramType = "path",dataType = "long",required = true)
    })


    @GetMapping("/courseInfo/{id}")
    public RestVo getCourseIno(@PathVariable("id") Long id){

        return new RestVo.Builder().success().build();
    }



}
