package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000116676144";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCfIeM4vYd4VPgsUhAXwQfpd6gU1Sxp4wGMBykREPQRcuh8hLI6+85nS3pzWVflOTX60w/Juhh5bbC0sL333RzCvR0Jd72TtV9Uk/DWqxSKvs5fNlH45kPRh0/XRBd+emwbS+7DM40cKysaVHH3UDXEIDCH2bXuRgHTHsZ0p5g1nsA4/rKaJ7a2zpFALIsHkTGWN+J4JY0EvvVaU5YngkmcMvV/gQoWlz58HDihuG3N64kFeCcsZBl3Exc4XnqG7bLlGZciS0pQeedXh91t5/6Y4M7z53+zGvu4jE/k/PJZdCImk1WpX5z3lGS6HxMkZpyqE8MBguPXa5flTprwe2hnAgMBAAECggEBAJzClUPf8QPpMFD4xkGgNlsXNMzQ8t+ccHmw1BOrz8Mgn0WKssjIJZw8DnRzHtMAeNyN7o+ac2GrXNejBICXoS11fpVFD8vib/axhh7yiVnkfQfuSvIWY9iUo2I8AajmkHiTZLGGpwuIuv1FEr++lDiQPT6WiVIgRMvlFTr1nkuyeFGG/k5Htaos4qGcGpg8PNwLAHNfi95va0W5We/zJTkp4jOuxDMCdSDIqnKxbrNNN8UB4WTclks91M04F8sinOJKJ/4edEac6bC/PWdXuzYcb4CpjeIX0fNyQLiw3Ja9YEsi6ah1Z2IJAkBmiwi9qib54e2zy43cR0ZIm2BTNoECgYEA2uMqhHJVbfLRWqDhXBafVCn9xBTa3WBIZeCfFBQlK612VdNlR3TuX9BZpTVzt+qe1TTJLf/Xbh+yVxDSXR0oqk4L4n/ZlAjG4fcgMgSWAzVbRXDcFrUfku1HrhIHWNqTphJvSk2CNIewbuckWActnfIUQpRK0f8Pb42+4KfAnF0CgYEAuh0MZKI/A1l0gJrbiRRBqIpVCIF9016xRZruj74rOo+StH3qr6eIm4iOkessqMyqflKEUCFT58XyKoH384bZfpP68tdU5gixn79IdkgugZVLpzcxKmOpW+74i5Mw5kwU3LwhTBdI4lk9Nc19AFXYKqrpk/AFBflyeEW74PM2K5MCgYBY6/BZ3hjWkc57AuCKiKYxit2MyuwfAv5mZNo7TfPLyqxIMZjzbo1oXzwL4ashDC96bfdMuKLMGhRZSnwrV60tgodRfJ7nhKlHIx3xM+u9Ye+yRicjEnHBPqPgE3LopeNVlCeiB9rdfEIwy7X4DPJ7N90DLzs2FGgw6WSh34RgAQKBgCQepRwWvOH6h3i6FSc6bi+2gSBAeVn/Q6o9klUFVEBuQsuSsGxcuE9vJjQ9jxJHfkM74n/mp/EQYppLVQLHRgih0Y81qT1nrIlTR03lXlk5z0/pjzop02GLNGNqMpBPbbEVNeUdk8CSDyYU9lCNWIGXX/OdHmx1Z/jdl8Plj7rPAoGBAMC+mzk8irMIHjY9mvONPZ2IHBZq7zSllvz0Jfi5f/ukIGnE0CgnF6nsteyuXLIcqrNvwxdJkunTeY8YdOP392tVz98x0sLHY0xlVXCH9YQ27FBIrs+P3j+FGIdqkqBf6taWjrA5g3+2LBipYY9K3dNDjud4SjKNMZM3+eX6iAJo";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoEhB49UZ7/Q4QTSZQRgngQkFUPzzor3+LXlT+dwi76ZchedVjJANu/zcWAznT+fB6unYiX8o2EWiS3+6NCQdZbUPJtwxXnSUeEgWz+n3viNzIDYXvODedOhvksWCeObyWt47bpDM05IL3RXke0rpktDkquC8CxGKQSDBix56h31nQtTW5sxMk7MQerLy3Hr1HfNcnaRv8dL27k2GmS9TMIfonpX9WBywKdOj35VW6h0jcRAA/vhJ6X6KR+cW9Xenm74Vqodjc+MiHcwNTgomk7Xm5cjvi4KHHGTemc45bTer+ivdUas6Ft/5A5AqJTXliE8PExxwD3c852vJFXcgNQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost/petshop/return.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost/petshop/return.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

