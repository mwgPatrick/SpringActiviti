package com.example.demo.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * BaseDao
 *
 * @author mawengang
 * @date 2019/12/10 10:46
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {

}
