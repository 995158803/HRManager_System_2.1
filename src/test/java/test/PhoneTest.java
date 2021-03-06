package test;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 * Created by caibaolong on 2017/2/5.
 * 实现发送手机短信
 */
public class PhoneTest {
    public static void main(String[] args) throws Exception {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        // PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = { new NameValuePair("Uid", "caibaolong"), // 注册的用户名
                new NameValuePair("Key", "71581f5e63fbf35f1622"), // 注册成功后,登录网站使用的密钥
                new NameValuePair("smsMob", "13817135910"), // 手机号码
                new NameValuePair("smsText", "java程序发的信息by CBL!!") };
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result);
        post.releaseConnection();
    }

}
