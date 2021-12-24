package com.cd.test.designpattern.proxy.staticproxy;


public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("放电影《肖生克的九叔》啦");
    }
}
