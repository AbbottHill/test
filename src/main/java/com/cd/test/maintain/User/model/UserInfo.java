package com.cd.test.maintain.User.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/8.
 */
@Data
public class UserInfo {
    private int id;
    private String name;
    private String email;
    private String telephone;
    private String address;
    private String roleId;
    private String password;
    private Date brithday;
    private Date createDate;
    //1:normal，0:locked
    private short validFlag;
    //1:male，0:female
    private short sex;
    private Integer countryId;

}