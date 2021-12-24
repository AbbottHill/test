package com.cd.test.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.io.IOException;

import static com.cd.test.encrypt.AesTest.readFile;

public class AesTest2 {

    public static void main(String[] args) throws Exception {

        String content = "密码1993";
        content = readFile();
        String password = "1234567890abcdef";
        System.out.println("需要加密的内容：" + content);
        System.out.println("encode: " + encode(content, password));
    }
  
    /**
     * 解密
     *
     * @param content   密文
     * @param key 加密密码
     * @return String
     * @throws Exception 异常
     */
    public static String decode(String content, String key) throws Exception {
        byte[] arr = string2ByteArr(content);
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(arr);
        return new String(original,"utf-8");
    }

    /**
     * 加密
     *
     * @param content      原文
     * @param key 加密密码
     * @return String
     * @throws Exception 异常
     */
    public static String encode(String content, String key) throws Exception {
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));
        return byteArrToString(encrypted);
    }

    /**
     * 将字节数组转换为16进制字符串
     * @param bcd 字节数组
     * @return String
     */
    public static String byteArrToString(byte[] bcd) {
/*        StringBuffer s = new StringBuffer(bcd.length * 2);
        for (int i = 0; i < bcd.length; i++) {
            s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
            s.append(bcdLookup[bcd[i] & 0x0f]);
        }
        return s.toString();*/

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bcd.length; i++) {
            String hex = Integer.toHexString(bcd[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();

    }

    /**
     * 将16进制字符串转换为字节数组
     * @param str 16进制字符串
     * @return byte[]
     */
    public static byte[] string2ByteArr(String str) {
        byte[] bytes;
        bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2),16);
        }
        return bytes;
    }
}