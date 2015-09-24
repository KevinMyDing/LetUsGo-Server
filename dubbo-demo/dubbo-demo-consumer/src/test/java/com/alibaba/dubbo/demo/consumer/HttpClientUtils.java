package com.alibaba.dubbo.demo.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by HOME on 2015/9/25.
 */


/**
 * 分装一个http请求的工具类
 *
 * @author 顾炜【guwei】 on 14-4-22.下午3:17
 */
public class HttpClientUtils {

    private static final Log log = LogFactory.getLog(HttpClientUtils.class);
    /**
     * 初始化HttpClient
     */
    private static HttpClient httpClient = null;

    /**
     * 生产HttpClient实例
     * 公开，静态的工厂方法，需要使用时才去创建该单体
     *
     * @return
     */
    public static HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager());
        }
        return httpClient;
    }

    /**
     * POST方式调用
     *
     * @param url
     * @param params 参数为NameValuePair键值对对象
     * @return 响应字符串
     * @throws java.io.UnsupportedEncodingException
     */
    public static String executeByPOST(String url, List<NameValuePair> params) {
        HttpClient httpclient = getHttpClient();

        HttpPost post = new HttpPost(url);


        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseJson = null;
        try {
            if (params != null) {
                post.setEntity(new UrlEncodedFormEntity(params));
            }
            responseJson = httpclient.execute(post, responseHandler);
            log.info("Successfully got result in POST method :" + responseJson);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            log.info("Failed with HTTP error in POST method :" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().closeExpiredConnections();
            httpclient.getConnectionManager().closeIdleConnections(30, TimeUnit.SECONDS);
        }
        return responseJson;
    }

    /**
     * Get方式请求
     *
     * @param url    带参数占位符的URL，例：http://----/User/user/center.aspx?_action=GetSimpleUserInfo&codes={0}&email={1}
    * @param params 参数值数组，需要与url中占位符顺序对应
    * @return 响应字符串
    * @throws java.io.UnsupportedEncodingException
    */
    public static String executeByGET(String url, Object[] params) {
        HttpClient httpclient = getHttpClient();

        String messages = MessageFormat.format(url, params);

        HttpGet get = new HttpGet(messages);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseJson = null;
        try {
            responseJson = httpclient.execute(get, responseHandler);
            log.info("Successfully got result in GET method :" + responseJson);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            log.info("Failed with HTTP error in GET method :" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Failed with HTTP error in GET method :" + e.getMessage());
        } finally {
            httpclient.getConnectionManager().closeExpiredConnections();
            httpclient.getConnectionManager().closeIdleConnections(30, TimeUnit.SECONDS);
        }
        return responseJson;
    }

    /**
     * @param url
     * @return
     */
    public static String executeByGET(String url) {
        HttpClient httpclient = getHttpClient();

        HttpGet get = new HttpGet(url);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseJson = null;
        try {
            responseJson = httpclient.execute(get, responseHandler);
            log.info("Successfully got result in GET method :" + responseJson);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            log.info("Failed with HTTP error in GET method :" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Failed with HTTP error in GET method :" + e.getMessage());
        } finally {
            httpclient.getConnectionManager().closeExpiredConnections();
            httpclient.getConnectionManager().closeIdleConnections(30, TimeUnit.SECONDS);
        }
        return responseJson;
    }
}

