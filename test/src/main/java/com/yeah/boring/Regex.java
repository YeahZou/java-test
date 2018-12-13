package com.yeah.boring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String [] argv) {
		String content = "#{JJJJJ},测试about, ${123VV}, {JJJffJJ}";
		String regex = "[\\#||\\$]\\{\\s*([^\\}\\s]+)\\s*}";
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group());
		}
		System.out.println(content);
	}
}
