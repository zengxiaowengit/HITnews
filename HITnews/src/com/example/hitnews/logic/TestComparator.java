package com.example.hitnews.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
public class TestComparator implements Comparator<Map<String, String>> {
	@Override
	public int compare(Map<String, String> o1, Map<String, String> o2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		for (String k : o1.keySet()) {
			try {
				d1 = format.parse(o1.get(k));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		for (String k : o2.keySet()) {
			try {
				d2 = format.parse(o2.get(k));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (d1.before(d2)) {
			return 1;
		} else if (d1.after(d2)) {
			return -1;
		} else {
			return 0;
		}
	}
}
