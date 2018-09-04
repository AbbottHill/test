package com.cd.test.regex;

import org.junit.Test;

import java.util.regex.Pattern;

public class RegexTest {

//    public static void main(String[] args) {
//        System.out.println(Pattern.matches("[\\W]", "."));
//    }

    @Test
    public void BigW() {
        System.out.println(Pattern.matches("[\\W]", "."));
    }

}
