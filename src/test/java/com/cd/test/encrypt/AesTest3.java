package com.cd.test.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static com.cd.test.encrypt.AesTest.readFile;

/**
 * 邮政对接
 */
public class AesTest3 {

    public static void main(String[] args) throws Exception {
        String content = "密码1993";
        content = readFile();
        String password = "1234567890abcd";
        password = "1234567890abcd";
        System.out.println("需要加密的内容：" + content);
        System.out.println("decode: " + AESDncode(password, content));
        System.out.println("encode: " + AESEncode(password, content));
        System.out.println("decode: " + AESDncode(password, AESEncode(password, content)));
    }

    public static String AESEncode(String encodeRules, String content)
            throws Exception {
        // 1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        // 2.根据ecnodeRules规则初始化密钥生成器
        // 生成一个128位的随机源,根据传入的字节数组
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(encodeRules.getBytes());
        keygen.init(128, random);
        // 3.产生原始对称密钥
        SecretKey original_key = keygen.generateKey();
        // 4.获得原始对称密钥的字节数组
        byte[] raw = original_key.getEncoded();
        // 5.根据字节数组生成AES密钥
        SecretKey key = new SecretKeySpec(raw, "AES");
        // 6.根据指定算法AES自成密码器
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
        byte[] byte_encode = content.getBytes("utf-8");
        // 9.根据密码器的初始化方式--加密：将数据加密
        byte[] byte_AES = cipher.doFinal(byte_encode);
        // 10.将加密后的数据转换为字符串
        // 解决办法：
        return new String(Base64.encodeBase64(byte_AES));
    }

    /**
     * AES根据密钥解密
     *
     * @param encodeRules
     *            密钥
     * @param content
     *            密文
     * @return
     */
    public static String AESDncode(String encodeRules, String content) throws Exception {
        // 1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        // 2.根据ecnodeRules规则初始化密钥生成器
        // 生成一个128位的随机源,根据传入的字节数组
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(encodeRules.getBytes());
        keygen.init(128, random);
        // 3.产生原始对称密钥
        SecretKey original_key = keygen.generateKey();
        // 4.获得原始对称密钥的字节数组
        byte[] raw = original_key.getEncoded();
        // 5.根据字节数组生成AES密钥core-site.xml
        SecretKey key = new SecretKeySpec(raw, "AES");
        // 6.根据指定算法AES自成密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 8.将加密并编码后的内容解码成字节数组
        byte[] byte_content = Base64.decodeBase64(content.getBytes("utf-8"));
        // 解密
        byte[] byte_decode = cipher.doFinal(byte_content);
        return new String(byte_decode, "utf-8");
    }

}