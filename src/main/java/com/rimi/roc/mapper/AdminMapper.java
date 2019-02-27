package com.rimi.roc.mapper;

import com.rimi.roc.commons.MyMapper;
import com.rimi.roc.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author 惜-梦
 * @description
 * @date 2019-02-27 16:19
 */
public interface AdminMapper extends MyMapper<Admin> {

    Admin selectByUsername(@Param("username") String username);
}
