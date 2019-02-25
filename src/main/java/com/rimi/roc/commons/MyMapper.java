package com.rimi.roc.commons;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 惜-梦
 * @description
 * @date 2019-02-22 14:43
 */
public interface MyMapper<T>  extends Mapper<T> , MySqlMapper<T> {

}
