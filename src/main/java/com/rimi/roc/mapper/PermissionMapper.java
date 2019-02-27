package com.rimi.roc.mapper;

import com.rimi.roc.commons.MyMapper;
import com.rimi.roc.pojo.Permission;

import java.util.List;

/**
 * @author 惜-梦
 * @description 权限
 * @date 2019-02-27 16:56
 */


public interface PermissionMapper extends MyMapper<Permission> {

    List<Permission> selectByUsername(String username);
}
