package com.cd.test.jdk8.stream;


import com.cd.test.beans.Widget;
import com.cd.test.enums.ColorEnum;

import javax.xml.bind.JAXB;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class StreamTest {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        Arrays.asList("123", "1", "lallal").stream().forEach(System.out::println);


        // filter
        List<Widget> widgets = Arrays.asList(new Widget(ColorEnum.RED, 10));
        int sum = widgets.stream()
                .filter(w -> w.getColor() == ColorEnum.RED)
                .mapToInt(w -> w.getWeight())
                .sum();
        System.out.println(sum);

        // 1. 对列表/数组中的每个元素都乘以2
        int[] ia = range(1, 10).map(i -> i * 2).toArray();
        List<Integer> result = range(1, 10).map(i -> i * 2).boxed().collect(toList());

        IntStream stream = Arrays.stream(ia);
        stream.forEach(value -> System.out.println(value));

        // 2. 计算集合/数组中的数字之和
        int sum1 = range(1, 1000).sum();
        int sum2 = range(1, 1000).reduce(0, Integer::sum);
        Integer sum3 = Stream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
        int sum4 = IntStream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
        System.out.println("sum: " + sum1);
        System.out.println("sum2: " + sum2);
        System.out.println("sum3: " + sum3);
        System.out.println("sum4: " + sum4);

        // 3. 验证字符串是否包含集合中的某一字符串
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
        final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";
        boolean match = keywords.stream().anyMatch(tweet::contains);
        Boolean reduce = keywords.stream().reduce(false, (b, keyword) -> b || tweet.contains(keyword), (l, r) -> l || r);
        System.out.println("match: " + match);
        System.out.println("reduce: " + reduce);

        // 4. 读取文件内容data.json
        String path = ClassLoader.getSystemResource("").getPath();
        try (BufferedReader reader = new BufferedReader(new FileReader(path + "data.txt"))) {
            String fileText = reader.lines().reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path + "data.txt"))) {
            List<String> fileLines = reader.lines().collect(toCollection(LinkedList<String>::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Stream<String> lines = Files.lines(new File(path + "data.txt").toPath(), Charset.defaultCharset()))
        {
            List<String> fileLines = lines.collect(toCollection(LinkedList<String>::new));
            fileLines.stream().forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. 根据集合中不同的元素输出不同的字符串
        range(1, 5).boxed().map(i -> { System.out.print("Happy Birthday "); if (i == 3) return "dear NAME"; else return "to You"; }).forEach(System.out::println);

        // 6. 过滤并分组集合中的数字
//        Map<String, List<Integer>> result = Stream.of(49, 58, 76, 82, 88, 90).collect(groupingBy(forPredicate(i -> i > 60, "passed", "failed")));

    }
}
