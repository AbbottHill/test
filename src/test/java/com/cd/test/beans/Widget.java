package com.cd.test.beans;

import com.cd.test.enums.ColorEnum;

public class Widget {
    private ColorEnum color;
    private int weight;

    public Widget(ColorEnum color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
