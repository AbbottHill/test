package com.cd.test.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String id;
    private String name;
    private Date birth;
}
