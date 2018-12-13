package com.yeah.boring;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Stupid {
	public static void main(String[] argv) {
		/*String arrToStr = Arrays.toString(new String[]{"1","2","3"});
		List strToArr = Arrays.asList(arrToStr);
		System.out.println(arrToStr);
		System.out.println(strToArr);*/
		
		
		Map <String, String> parameters = new HashMap<String, String>();
		parameters.put("buildPackId", "myContainerVersion");
		parameters.put("appName", "myApp");
		parameters.put("ecsId", "myApp");
		parameters.put("description", "myApp-description");
		parameters.put("regionId", "cn-baijing");
		parameters.put("Format", "JSON");
		parameters.put("healthCheckURL", "http://192.168.0.22:8080/xxx");
		parameters.put("Version", "20151201");
		parameters.put("AccessKeyId", "yeah");
		//parameters.put("Signature", "myContainerVersion");
		parameters.put("Timestamp", "2018-08-21T08:57:46Z");
		parameters.put("SignatureMethod", "HMAC-SHA1");
		parameters.put("SignatureVersion", "1.0");
		parameters.put("SignatureNonce", "4fec4ad0-a94c-464f-883d-674a3b9e612b");
		parameters.put("Action", "/json/app/createAppJson.htm");
		//String[] sortedKeys = (String[])parameters.keySet().toArray(new String[0]);
	    //Arrays.sort(sortedKeys);
	    //System.out.println(Arrays.toString(sortedKeys));
	    
	    try {
			System.out.println(computeSignature("POST", parameters, "zouyeah==88881788"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String computeSignature(String httpMethod, Map<String, String> parameters, String accessKeySecret)
		    throws Exception
	{
		    String[] sortedKeys = (String[])parameters.keySet().toArray(new String[0]);
		    Arrays.sort(sortedKeys);
		    
		
		    StringBuilder canonicalizedQueryString = new StringBuilder();
		    for (int i = 0; i < sortedKeys.length; i++)
		    {
		      String k = sortedKeys[i];
		      String v = (String)parameters.get(k);
		      if (i != 0) {
		        canonicalizedQueryString.append("&");
		  }
		  canonicalizedQueryString.append(URLEncoder.encode(k, "UTF-8")).append("=").append(URLEncoder.encode(v, "UTF-8"));
		}
		StringBuilder stringToSign = new StringBuilder();
		stringToSign.append(httpMethod).append("&%2F&");
		stringToSign.append(URLEncoder.encode(canonicalizedQueryString.toString(), "UTF-8"));
		System.out.println("stringToSign: " + stringToSign.toString() + ",\n" + "key: " + accessKeySecret + "&\n");
		byte[] signatureBytes = sign(accessKeySecret + '&', stringToSign.toString());
		    return new String(Base64.getEncoder().encodeToString(signatureBytes));
	}
	
	  public static byte[] sign(byte[] key, byte[] data)
		throws NoSuchAlgorithmException, InvalidKeyException
	  {
	    Mac mac = Mac.getInstance("HmacSHA1");
	    mac.init(new SecretKeySpec(key, "HmacSHA1"));
	    return mac.doFinal(data);
	  }
	  
	  public static byte[] sign(String key, String data)
	    throws InvalidKeyException, NoSuchAlgorithmException
	  {
	    byte[] kb = null;
		try {
			kb = key.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	    
	    byte[] db = null;
		try {
			db = data.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    
	    byte[] ret = sign(kb, db);
	    
	    return ret;
	  }
}
