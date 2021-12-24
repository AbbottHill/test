package com.cd.test.mybatis;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserMapper {
  @Select("select * from T_HD_USER t WHERE f_id = #{id}")
  Map selectUser(String id);
}