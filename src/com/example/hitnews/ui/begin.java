package com.example.hitnews.ui;

import com.example.hitnews.logic.TestComparator;
import com.example.hitnews.R;
import com.example.hitnews.ui.MainActivity;
import android.widget.AdapterView.OnItemClickListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.widget.TextView;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Collections;


import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import com.example.hitnews.user.key_and_web;
public class begin extends Activity implements OnItemClickListener {

	
	Document doc;
	public static List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	public String key ; 
	public static List<Map<String,String>> mylist;
	public String t;
	public String web;
	char web_inf[];
	key_and_web mykeyandweb = new key_and_web();
	//String tmp[];
	public static ListView listView;
	static String mynews = "";
	 SimpleAdapter adapter ,adapter1;
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);
		adapter  = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
				new String[] { "title","inf" }, new int[] {
				android.R.id.text1,android.R.id.text2});
		/*
		adapter1 = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
				new String[] { "title","inf" }, new int[] {
				android.R.id.text1,android.R.id.text2});
				*/
		 web = web_choose.getweb();
		 key = key_choose.getkey();
		 Log.e("aa", web);
		 Log.e("aaa", key);
		 mykeyandweb.tmp = key.split(" ");
		 web_inf = web.toCharArray();
		listView = (ListView) findViewById(R.id.listView1);
		load();
		listView.setOnItemClickListener(this);
		 listView.setAdapter(adapter);
				Collections.sort(list, new TestComparator());
					mylist = list;
	}
	@Override
	
	protected void onRestart() {
        super.onRestart();
        Log.e("aaa", "start onRestart~~~");
        String k = Integer.toString(list.size());
        /*
        for(int i = 0 ; i<list.size() ;i++)
        {
        	String title = list.get(i).get("title");
        	String inf = list.get(i).get("inf");
        	Log.e(title, inf);
        }
        */
        setContentView(R.layout.begin);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
      // listView.showContextMenu();
       
	
    }
	public  void load() 
	{
		com.example.hitnews.ui.MainActivity.read = 1;
		//Log.e("a","mykeyandweb.tmp.length");
		//Log.e("a", "http://www.baidu.com/s?q1="+ java.net.URLEncoder.encode(mykeyandweb.tmp[i]) + "&rn=100&lm=7&q5=1&q6="+mykeyandweb.web_site[0]);
		for(int i = 0; i < mykeyandweb.tmp.length; i++)
		{
			//Log.e("aaa",mykeyandweb.tmp[i] );
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
	}
			
				
	
			
		
		
		
		
		
	
	


	public String getHtmlString(String urlString) {
		try {
			URL url = null;
			url = new URL(urlString);

			URLConnection ucon = null;
			ucon = url.openConnection();

			InputStream instr = null;
			instr = ucon.getInputStream();

			BufferedInputStream bis = new BufferedInputStream(instr);

			ByteArrayBuffer baf = new ByteArrayBuffer(500);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			return EncodingUtils.getString(baf.toByteArray(), "gbk");
		} catch (Exception e) {
			return "";
		}
	

	}
	
	public void onItemClick(AdapterView parent, View v, int position, long id)
	{
		Document doc1 = null;
		String web_from = null;
		TextView mytextview = null;
		setContentView(R.layout.news_show);
		try
		{			
			
			
			doc1 = Jsoup.connect(list.get(position).get("href")).get();
			 web_from = list.get(position).get("web_from");
			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(doc1 != null)
		{
			
			
			int j = Integer.parseInt(web_from);
			Elements ees = null;
			Element eees = null;
			if(j == 0)
			{
				
				ees = doc1.getElementsByClass("articletext");
				Log.e("aa", ees.text());
	
			}
			else if(j == 1)
				ees = doc1.getElementsByClass("field-name-body");
			else if(j == 2)
				ees = doc1.getElementsByClass("font1");
			else if(j == 3 || j == 5 || j == 7 || j == 9)
				ees = doc1.getElementsByClass("font1");
			else if(j == 4)
			{
		
				eees = doc1.getElementById("text");
				
			}
			else if(j == 6)
				ees = doc1.getElementsByClass("12");
			else if(j == 8)
				ees = doc1.getElementsByClass("page_content");
		
			if(j != 4)
				mynews = ees.text();
			else
				mynews = eees.text();
			Intent i = new Intent(this, news_show.class);
		
			startActivity(i);
			
		
		
			
	}
	}
	
	public static  List<Map<String,String>> getmylist()
	{
		return mylist;
	}
	public static String getmynews()
	{
		return mynews;
	}
}
