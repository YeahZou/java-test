package com.yeah.boring;

import java.util.Arrays;

public class TestEnum {

	public enum Day {
		MONDAY(0, "周一"), TUESDAY(1, "周二"), WEDNESDAY(2, "周二"),
	    THURSDAY(3, "周二"), FRIDAY(4, "周二"), SATURDAY(5, "周二"), SUNDAY(6, "周二");
		
		private Day(int value, String valueText) {
			this.value = value;
			this.valueText = valueText;
		}
		
		private int value;
		private String valueText;
		
		public int getValue() {
			return this.value;
		}
		
		public String getValueText() {
			return this.valueText;
		}
	}
	
	public static void main(String[] argv) {
		Day[] day = Day.values();
		
		String typeScope = Arrays.toString(day).replace("]", ", mediaPath, oobInfo]");
		System.out.println(typeScope);
	}
}
