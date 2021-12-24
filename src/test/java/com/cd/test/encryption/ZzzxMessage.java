package com.cd.test.encryption;

import com.cd.test.encryption.aes.AdvancedEncryptionStandard;
import com.cd.test.encryption.aes.ParseSystemUtil;
import com.cd.test.encryption.md5.EncryptionMD5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ZzzxMessage {


    public static void main(String[] args) throws Exception {
        UUID uuid = UUID.randomUUID();
        String randomStr = uuid.toString().replaceAll("-", "");
        System.out.println(randomStr);
        System.out.println(randomStr.length());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        long time = now.getTime();
//        String content = "appId=ZZZX&content=市民反映您AC**4C在望江西路挡道，请挪车。公安便民，关注安徽公安网微信或搜皖警下载APP。&phone=13866131067&randomStr=u2GIGtXVqTF0aHtY4JXterYlXxghTzaM&timeStamp=1528803716624";
        String content = "appId=ZZZX&content=测试短信（" + simpleDateFormat.format(now) + "）。&phone=18255185611&randomStr=" + randomStr + "&timeStamp=" + time;
        System.out.println(content);
        String password = "8JIjuUHkims";

        // 加密
        byte[] encrypt = AdvancedEncryptionStandard.encrypt(content, password);
        //如果想要加密内容不显示乱码，可以先将密文转换为16进制
        String hexStrResult = ParseSystemUtil.parseByte2HexStr(encrypt);
        System.out.println(hexStrResult);


        System.out.println(EncryptionMD5.GetMD5Code(hexStrResult));
    }

}
