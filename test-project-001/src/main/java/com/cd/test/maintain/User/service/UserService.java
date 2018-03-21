package com.cd.test.maintain.User.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserService {

    List<Map> queryUser(Map params);
}