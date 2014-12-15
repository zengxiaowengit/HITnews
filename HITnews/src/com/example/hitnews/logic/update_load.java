package com.example.hitnews.logic;

import com.example.hitnews.logic.TestComparator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.hitnews.R;
import com.example.hitnews.ui.key_choose;
import com.example.hitnews.ui.web_choose;
import com.example.hitnews.user.key_and_web;

public class update_load extends Activity  {

	
	Document doc;
	public List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	public String key ; 
	public static List<Map<String,String>> mylist;
	public String t;
	public String web;
	char web_inf[];
	key_and_web mykeyandweb = new key_and_web();
	//String tmp[];
	ListView listView;
	public void init() {
		
		 web = web_choose.getweb();
		 key = key_choose.getkey();
		Log.e("a",web);
		// Log.e("a", "111");
		 mykeyandweb.tmp = key.split(" ");
		 web_inf = web.toCharArray();
		
		//listView = (ListView) findViewById(R.id.listView1);
		load();
		//clear();
	}
	
	public  void load() 
	{
		Log.e("a","mykeyandweb.tmp.length");
		//Log.e("a", "http://www.baidu.com/s?q1="+ java.net.URLEncoder.encode(mykeyandweb.tmp[i]) + "&rn=100&lm=7&q5=1&q6="+mykeyandweb.web_site[0]);
		for(int i = 0; i < mykeyandweb.tmp.length; i++)
		{
			Log.e("aaa",mykeyandweb.tmp[i] );
			for(int j = 0; j <= 9 ;j++)
			{
				
				if(web_inf[j] == '0') continue;
		
				try {
					if(j==0 || j==3 || j==4 || j==5 || j==7 || j==8 || j==9 || j==2 || j==6 )
						doc  =  Jsoup.connect("http://www.baidu.com/s?q1="+mykeyandweb.tmp[i]+"&q2=&q3=&q4=&rn=100&lm=7&ct=0&ft=&q5=1&q6="+mykeyandweb.web_site[j]+"&tn=baiduadv").get();		
					else if(j == 1)
						doc = Jsoup.connect("http://www.youdao.com/search?q="+java.net.URLEncoder.encode(mykeyandweb.tmp[i])+"+site%3A"+mykeyandweb.web_site[j]+"&ue=utf8&keyfrom=web.index").get();
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				//Log.e("ww", doc.text());
				Elements es;
				   if(j != 1)
					 es = doc.getElementsByClass("result");
				   else 
					 es = doc.getElementsByClass("res-list");
					for (Element e : es) 
					{
						Map<String, String> map = new HashMap<String, String>();
						map.put("title", e.getElementsByTag("h3").text());
						if(j != 1)
						{
							String tmptime = e.getElementsByClass("g").text().toString();
							int end =tmptime.length()-1;
							int begin =end-10;
							String mytime = tmptime.substring(begin,end);
							//Log.e("aa", mytime);
							mytime = mytime.substring(mytime.indexOf("2"));
							mytime=mytime.trim();
							map.put("inf",mykeyandweb.web_from[j]+"       "+mytime);
							map.put("time", mytime);
						}
						else 
						{
							String tmptime = e.getElementsByTag("cite").text().toString();
							int end =tmptime.length();
							int begin =end-10;
							String mytime = tmptime.substring(begin,end);
							map.put("inf",mykeyandweb.web_from[j]+"       "+mytime);
							map.put("time", mytime);
						}
						String tt =	e.getElementsByTag("a").attr("href").toString();
						map.put("href", tt);
						map.put("web_from", Integer.toString(j));
						list.add(map);
						
						
					}
			}
		}
					
					Collections.sort(list, new TestComparator());
					mylist = list;
			
		
	}
	public void clear()
	{
		list.clear();
	}
	public static List<Map<String,String>>  getmylist()
	{
		return mylist;
	}
	
}
