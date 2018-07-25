package com.cd.test.stream;


import com.cd.test.enums.ColorEnum;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class StreamTest {
    public static void main(String[] args) {

        List<Widget> widgets = Arrays.asList(new Widget(ColorEnum.RED, 10));
        int sum = widgets.stream()
                .filter(w -> w.getColor() == ColorEnum.RED)
                .mapToInt(w -> w.getWeight())
                .sum();
        System.out.println(sum);



    }

    static class Widget {
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
}

class Range_test {
    public static void main(String[] args) {
        // Range是半开区间
        int[] ia = range(1, 10).map(i -> i * 2).toArray();
        List<Integer> result = range(1, 10).map(i -> i * 2).boxed().collect(toList());

        IntStream stream = Arrays.stream(ia);
        stream.forEach(value -> System.out.println(value));
    }
}