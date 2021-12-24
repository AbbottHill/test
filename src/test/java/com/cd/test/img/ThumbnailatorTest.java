package com.cd.test.img;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;

import java.io.*;
import java.util.Base64;

public class ThumbnailatorTest {

    @Test
    public void compress() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\桌面.jpeg");
        int available = fileInputStream.available();
        byte[] bytes = new byte[available];
        fileInputStream.read(bytes);

        ByteInputStream byteInputStream = new ByteInputStream(bytes, bytes.length);
//        File file = new File();
//        Thumbnails.of(byteInputStream).scale(0.5f).outputQuality(0.2f).toFile("C:\\Users\\Administrator\\Desktop\\81f.jpeg");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\84.jpeg");
        Thumbnails.of(byteInputStream).scale(0.5f).outputQuality(0.2f).toOutputStream(outputStream);
        byte[] bytes1 = outputStream.toByteArray();
        System.out.println(Base64.getEncoder().encodeToString(bytes1));
    }

}
