package com.cd.test.io.file;

import com.cd.test.utils.StringUtil;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChuD
 * @date 2020-09-25 10:11
 */
public class MatchVedioAndSrt {

    @Test
    public void mkdir() {
        String basePath = "C:\\Users\\Administrator\\Desktop\\分集整理";
        for (int i = 0; i < 10; i++) {
            String seriesPath = basePath + "\\" + StringUtil.zeroFill(i + 1);
            File file = new File(seriesPath);
            file.mkdirs();
            for (int j = 0; j < 24; j++) {
                File innerFile = new File(seriesPath + "\\" + (i + 1) + "" + StringUtil.zeroFill(j + 1));
                innerFile.mkdirs();
            }
        }
    }

    @Test
    public void copyVideo() {
        String basePath = "C:\\Users\\Administrator\\Desktop\\friends";
        // 视频或字幕的路径
        String videoPath = "C:\\Users\\Administrator\\Desktop\\老友记第十季 视频+SRT+音频+LRC\\纯英文SRT";
        File file = new File(videoPath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
//        for (int i = 0; i < 1; i++) {
            File video = files[i];
            String name = video.getName();
//            int i1 = name.indexOf(".", 0);
//            int i2 = name.indexOf(".", i1 + 1);
//            String substring = name.substring(i1, i2);
            Pattern pattern = Pattern.compile("(S\\d*)(E\\d*)");
//            pattern = Pattern.compile("(S\\d*).(E\\d*)"); // 第十季视屏特殊处理
            pattern = Pattern.compile("(s\\d{2})(\\d{2})"); // 第十季字幕特殊处理
            Matcher matcher = pattern.matcher(name);
            while (matcher.find()) {
                String group = matcher.group(0);
                String group1 = matcher.group(1);
                String group2 = matcher.group(2);
//                System.out.println(group);
//                System.out.println(group1);
//                System.out.println(group2);

//                File series = new File(basePath + "/" + group1);
                File episode = new File(basePath + "/" + group1 + "/" + group);
                episode = new File(basePath + "/" + group1 + "/" + group1 + "." + group2); // 第十季视屏特殊处理
                episode = new File(basePath + "/" + group1 + "/" + group1 + ".E" + group2); // 第十季字幕特殊处理
                episode.mkdirs();

                try (FileInputStream fileInputStream = new FileInputStream(video);
                     FileOutputStream fileOutputStream = new FileOutputStream(episode.getAbsolutePath() + "/" + name);
                    ) {
                    BufferedInputStream bis = new BufferedInputStream(fileInputStream, 2048);
                    byte[] b=new byte[2048];  //①..??为什么还要用到数组
                    int len = 0;
                    while (-1 != (len = bis.read(b))) {
                        fileOutputStream.write(b, 0, len);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
