package com.yeah.boring;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

public class Samples {
	public static void main(String [] argv) {
		/*List<String> toList = Arrays.asList("a", "b", "c", "d");
		System.out.println(toList.toString());
		
		JSONObject obj = new JSONObject();
		obj.put("id", 1234);
		obj.put("idTxt", "1234");
		System.out.println(obj.getLong("idTxt"));
		System.out.println(obj.getBoolean("id"));*/
		
		String str = "#afafsfsf\ndbexec -v --nocheck --filter  ";
		String []fp = {"", " ", "-", "\"\"", "''", "'\"", "\"'", "a", "aa", "a b c", "'-a'", "-'-a'", "\"-a\"", "\"a b c\"", "\"-a-b-c\"", "\"", "'"};
		//Pattern p = Pattern.compile("^\\s*dbexec.+?-filter\\s+([^-\\s].*)$");
		
		
		for (String pattern: fp) {
			Pattern p = Pattern.compile("^\\s*dbexec.+?-filter\\s+([^-\\s].*)$");
			Matcher m = p.matcher(str + pattern);
			System.out.println(str + pattern);
			String filter = "";
			if (m.find() && m.groupCount() == 1) {
				System.out.println("One:"+ m.group(1));
				String regex = "^(\\S+)";
				if (m.group(1).startsWith("\"")) {
					regex = "^\"([^\"]+)\"";
				} else if (m.group(1).startsWith("'")) {
					regex = "^\'([^\']+)\'";
				}
				p = Pattern.compile(regex);
				m = p.matcher(m.group(1));
				if (m.find() && m.groupCount() == 1) {
					System.out.println("Two:"+m.group(1));
					filter = m.group(1);
				}
			}
			
			System.out.println("filter:" + filter + "123");
		}
		
		String[] lines = "abcd\nefg\r\nhijk".split("(\n|\r\n)");
		for (String line:lines) {
			System.out.println(line);
		}
	}
	
}
