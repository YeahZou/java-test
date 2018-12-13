package com.yeah.boring;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class interview {
	public class JobSort {
		
	}
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] argv) {
		String[][] jobArr = {
			{"2018-10-10 09:00:01","2018-10-10 12:02:33"},
			{"2018-10-10 08:12:03","2018-10-10 20:13:36"},
			{"2018-10-10 14:12:43","2018-10-10 14:22:44"},
			{"2018-10-10 22:12:23","2018-10-10 23:44:23"},
			{"2018-10-10 05:12:23","2018-10-10 06:14:23"}
		};
		
		Long [] jobStartTime = new Long[5];
		Long [] jobEndTime = new Long[5];
		
		for (int i = 0; i < jobArr.length; i++) {
			try {
				jobStartTime[i] = dateFormat.parse(jobArr[i][0]).getTime();
				jobEndTime[i] = dateFormat.parse(jobArr[i][1]).getTime();
			} catch (ParseException e) {
			}
		}
		
		Arrays.sort(jobStartTime);
		Arrays.sort(jobEndTime);
		
		Long totalTime = 0L;
		int endPos = 0;
		for (int i = 1; i < jobStartTime.length; i++) {
			if (jobStartTime[i] > jobEndTime[endPos]) {
				totalTime += jobEndTime[endPos] - jobStartTime[endPos];
				endPos = i;
			}
		}
	}
}
