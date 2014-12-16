<<<<<<< HEAD
package com.example.hitnews.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import android.util.Log;
public class TestComparator implements Comparator<Map<String, String>> {
	@Override
	public int compare(Map<String, String> o1, Map<String, String> o2) {
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date d1 = null;
		//Date d2 = null;
		String d1 = "2015";
		String d2 = "2015";
		for (String k : o1.keySet()) {
			
				if(k.equals("time"))	
				{
					//Log.e("aa", k);
					d1 = o1.get(k);
					//Log.e("aa", d1);
				}
			 
		}
		for (String k : o2.keySet()) {
			
				if(k.equals("time"))
					d2 = o2.get(k);
			
		}
		return d2.compareTo(d1);
	}
}
=======
package com.example.hitnews.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import android.util.Log;
public class TestComparator implements Comparator<Map<String, String>> {
	@Override
	public int compare(Map<String, String> o1, Map<String, String> o2) {
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date d1 = null;
		//Date d2 = null;
		String d1 = "2015";
		String d2 = "2015";
		for (String k : o1.keySet()) {
			
				if(k.equals("time"))	
				{
					//Log.e("aa", k);
					d1 = o1.get(k);
					//Log.e("aa", d1);
				}
			 
		}
		for (String k : o2.keySet()) {
			
				if(k.equals("time"))
					d2 = o2.get(k);
			
		}
		return d2.compareTo(d1);
	}
}
>>>>>>> 74520f853ded7e148cbf1916e9c7658dc6f8c4f7
