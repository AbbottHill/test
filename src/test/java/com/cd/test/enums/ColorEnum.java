package com.cd.test.enums;

public enum ColorEnum {
    RED, BLUE, BLACK;

    public void printAll() {
        for (ColorEnum color : ColorEnum.values()) {
            System.out.println(color.ordinal() + ": " + color.name());
        }
    }
}
