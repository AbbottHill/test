package com.cd.test.httpclient;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTest {
    public static void main(String[] args) throws Exception { //测试代码
        CloseableHttpClient closeableHttpClient = getCloseableHttpClient();
        if (closeableHttpClient == null) { //使用前要先判断是否成功生成
            return;
        }
        HttpGet httpGet = new HttpGet("https://www.baidu.com"); //请求页面一般是HttpGet
        for (int i = 0; i < 200; i++) {
            CloseableHttpResponse closeableHttpResponse = null;
            try {
                closeableHttpResponse = closeableHttpClient.execute(httpGet);
                System.out.printf("-- i:%4d  content:%s\n", i, closeableHttpResponse.getEntity().getContent()); //注意这里拿到的content是inputstream，具体怎么用，看情况
            } finally {
                closeableHttpResponse.close(); //操作结束后一定关闭response
            }
            { //附：post请求代码示例
                HttpPost httpPost = new HttpPost("https://www.example.com"); //这里写要请求的网址
                List<BasicNameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair("key", "value"));
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params);
                httpPost.setEntity(urlEncodedFormEntity);
            }
        }
    }

    /**
     * 获取一个配有poolingConnectionManager的httpClient
     * @return 失败返回null
     */
    private static CloseableHttpClient getCloseableHttpClient() {
        TrustStrategy trustStrategy = new TrustStrategy() {
/*

            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return false;
            }
*/

            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                //返回true就会信任所有凭证，某些应用只是需要https的加密传输功能而不需要进行实际的认证，这时候就需要return true
                return true;
            }
        };
        SSLContext sslContext = null;
        try {
            sslContext = SSLContextBuilder.create().loadTrustMaterial(trustStrategy).build();
        } catch (Exception e) {
            return null;
        }
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connManager.setMaxTotal(20); //设置连接池总大小
        connManager.setDefaultMaxPerRoute(20); //设置与某个主机默认最大连接数
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setConnectionManager(connManager).build(); //设置连接池，生成httplcient
        return closeableHttpClient;
    }
}
