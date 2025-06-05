package test;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author yuxiang_chu
 * @since 2023/10/11 18:28
 */
public class HttpTest {

    public static void main(String[] args) {
        try {
            String reqStr = "{\n" +
                    "    \"idempotentKey\": \"1501414017658974208\",\n" +
                    "    \"nonce\": \"FORM_API431202310111741423570001\",\n" +
                    "    \"timestamp\": 1697017302357,\n" +
                    "    \"mchNo\": \"54007026537209857\",\n" +
                    "    \"userNo\": \"1444130252204724224\",\n" +
                    "    \"productId\": 1501414017658974208,\n" +
                    "    \"productName\": \"流程测试\",\n" +
                    "    \"totalAmount\": 10,\n" +
                    "    \"payAmount\": 10,\n" +
                    "    \"fee\": 1,\n" +
                    "    \"payType\": \"1\",\n" +
                    "    \"clientIp\": \"223.104.66.99\",\n" +
                    "    \"wxAppId\": \"wx0a15ea0416046810\",\n" +
                    "    \"code\": \"0f1JrE0w3oFpv13I5u3w3ztPE84JrE0N\",\n" +
                    "    \"openId\": \"oRthy6wmeFQFeVkytzJ2hzB-Av-I\",\n" +
                    "    \"formId\": 1476482193063034881\n" +
                    "}";
            // 添加信任主机
            // 创建连接
            URL url = new URL("https://form.feidee.cn/v1/mch/order");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            // 设置请求方式
            connection.setRequestMethod("POST");
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 设置发送数据的格式json
            connection.setRequestProperty("Content-Type","application/json");
            // 设置token appkey
            connection.setRequestProperty("X-Sign","a6fc3d5b5df56b0be45a6a6ef858d751");
            connection.setRequestProperty("X-App-Id","suiformapiX");
            connection.setRequestProperty("Authorization","dgindijgdindgindgd");
            connection.setRequestProperty("Client-Channel-No","FORM_API");
            connection.setRequestProperty("Client-App-id","wx0a15ea0416046810");
            connection.setRequestProperty("Api-Trace-Id","5cbc9964-50fe-4ec0-8a31-e745e5501529");
            // 设置接收数据的格式json
            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
            // 阿里巴巴的fastjson
            out.append(reqStr);
            out.flush();
            out.close();
            // 请求成功
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // 读取响应
                StringBuffer respResult = new StringBuffer();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String line;
                while ((line = reader.readLine()) != null) {
                    respResult.append(line);
                }
                reader.close();
                System.out.println("Req Success{}" + respResult.toString());
                return;
            }
        } catch (Exception e) {
            System.out.println("Req Error{}" + e.getMessage());
        }
    }
}
