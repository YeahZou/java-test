package com.yeah.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.aliyun.edas.open.api.EdasApiClient;

/**
 * Hello world!
 *
 */
public class AliEdas 
{
    public static void main( String[] args )
    {
    	String host = "http://192.168.0.22:8080";
    	String ak = "yeah";
    	String sk = "zouyeah==88881788";
    	
    	/**
    	 * 3.2创建应用 
    	 */
    	EdasApiClient edasSdk = new EdasApiClient(host, ak, sk);
    	Map<String, String> params = new HashMap<String, String>();
    	// 第一个参数必填，其余可选
    	params.put("appName", "myApp");
    	params.put("description", "myApp-description");
    	params.put("regionId", "cn-baijing");
    	params.put("buildPackId", "myContainerVersion");
    	params.put("healthCheckURL", "http://192.168.0.22:8080/xxx");
    	params.put("ecsId", "myApp");
        try {
			String res = edasSdk.callApi("/json/app/createAppJson.htm", params);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("调用接口失败，异常：" + e.getMessage());
		}
        
        /**
         *  部署应用
         */
       /* params = new HashMap<String, String>();
        params.put("appId","myAppId");
        params.put("deployType","WAR"); // WAR/URL
        params.put("deployTo","all"); // all/beta/unbeta
        params.put("deployCount","1"); // 1=不分批部署
        params.put("warUrl","http://192.168.0.24:8080/xxx"); // 
        params.put("app_packge",""); // 
        try {
			String res = edasSdk.callApi("/json/app/deployAppJson.htm", params);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("调用接口失败，异常：" + e.getMessage());
		}*/
        
        /**
         *  部署应用
         */
       /* params = new HashMap<String, String>();
        params.put("appId","myAppId");
        params.put("cid","oneDeployTaskId");
        try {
			String res = edasSdk.callApi("/json/audit/queryAuditDetailJson.htm", params);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("调用接口失败，异常：" + e.getMessage());
		}*/
    }
}
