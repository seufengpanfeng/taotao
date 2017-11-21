package com.taotao.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2017/11/21.
 */
public class HttpClient {
    @Test
    public void doGet() throws Exception{
        //创建一个httpclient对象
        //不能new，因为是抽象类
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个get对象
        HttpGet get = new HttpGet("http://www.baidu.com");
        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);
        //获取相应结果
        int statusCode = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity,"utf-8");//防止返回的是乱码
        //一般都是有编码格式的，对于响应
        System.out.println(string);
        //关闭httpclient
        response.close();;
        httpClient.close();
    }
@Test
    public void doGetWithParam() throws  Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("http://www.sougou.com/web");
        uriBuilder.addParameter("query","花千骨");
        HttpGet get = new HttpGet(uriBuilder.build());
        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);
        //获取相应结果
        int statusCode = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity,"utf-8");//防止返回的是乱码
        //一般都是有编码格式的，对于响应
        System.out.println(string);
        //关闭httpclient
        response.close();;
        httpClient.close();
    }
    @Test
    public void doPost() throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
        CloseableHttpResponse response = httpClient.execute(post);
        String string = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(string);
        response.close();
        httpClient.close();
    }

    @Test
    public void doPostWithParam() throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
        List<NameValuePair>kvList = new ArrayList<>();
        kvList.add(new BasicNameValuePair("username","张三"));
        kvList.add(new BasicNameValuePair("password","123"));

        StringEntity entity = new UrlEncodedFormEntity(kvList,"utf-8");
        //包装成一个实体
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        String string = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(string);
        response.close();
        httpClient.close();
    }
}
