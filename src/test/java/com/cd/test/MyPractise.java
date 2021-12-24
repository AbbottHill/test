package com.cd.test;

import com.cd.test.AnnotationTest.AnnotationTest;
import com.mchange.util.Base64Encoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Base64;

public class MyPractise {

    public static void main(String[] args) {
        copyFile();
    }

    public static void copyFile() {
        String path = ClassLoader.getSystemResource("").getPath();
        String x = path + "data.txt";
        System.out.println(x);
//        System.out.println(ClassLoader.getSystemResource("/").getPath());

        try (FileInputStream fileInputStream = new FileInputStream(x);
             FileOutputStream fileOutputStream = new FileOutputStream("D:\\result.txt");
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 200);
        ) {
            byte[] bytes = new byte[1024];
            int index;


            while ((index = fileInputStream.read(bytes)) > 0) {
                byteArrayOutputStream.write(bytes, 0, index);
            }
            byte[] bytes1 = byteArrayOutputStream.toByteArray();

            String encode = new BASE64Encoder().encode(bytes1);
            byte[] bytes2 = new BASE64Decoder().decodeBuffer(encode);

            byte[] encode1 = Base64.getEncoder().encode(bytes1);
            byte[] decode = Base64.getDecoder().decode(encode1);
            System.out.println(new String(encode1));

            System.out.println("BASE64Decoder\n" + new String(bytes2));
            System.out.println("Base64\n" + new String(decode));
            bufferedOutputStream.write(bytes2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
