package com.cd.test.io.fileoutputstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class PrintStreamDemo {


    public static void main(String[] args) throws IOException {
        write();
        write();
        read();
    }

    private static void write() throws IOException {
        // 你好\n你好
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\a.txt", true)));
//        PrintWriter printWriter = new PrintWriter(new FileOutputStream("c:\\a.txt", true));
//        printWriter.write("你好\n");
//        bufferedWriter.close();
//        printWriter.close();

        // 你好 （多个输出流同时操作一个文件，要将append 设置为true，否则即使输出流没有调用write方法原数据也会被覆盖）
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\a.txt")));
//        PrintWriter printWriter = new PrintWriter(new FileOutputStream("c:\\a.txt", true));
//        printWriter.write("你好\n");
//        bufferedWriter.close();
//        printWriter.close();


        // "" empty string
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("c:\\a.txt", true));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\a.txt", true)));
//        printWriter.write("你好\n");
        bufferedWriter.write("你好\n");
//        printWriter.close();
        bufferedWriter.close();
        printWriter.close();

    }

    private static void read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\a.txt")));
        String s = null;
        while((s = bufferedReader.readLine())!= null){
            System.out.println(s);
        }
        bufferedReader.close();
    }
}


