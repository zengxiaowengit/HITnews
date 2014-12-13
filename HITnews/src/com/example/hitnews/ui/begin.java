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
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import com.example.hitnews.user.key_and_web;
public class begin extends Activity implements OnItemClickListener {

	
	Document doc,doc1;
	public List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	public String key ; 
	public String t;
	public String web;
	char web_inf[];
	key_and_web mykeyandweb = new key_and_web();
	//String tmp[];
	ListView listView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);
		 web = web_choose.getweb();
		 key = key_choose.getkey();
		Log.e("a",web);
		// Log.e("a", "111");
		 mykeyandweb.tmp = key.split(" ");
		 web_inf = web.toCharArray();
		
		listView = (ListView) findViewById(R.id.listView1);
		load();
	}
	
	protected void load() 
	{
		Log.e("a","mykeyandweb.tmp.length");
		//Log.e("a", "http://www.baidu.com/s?q1="+ java.net.URLEncoder.encode(mykeyandweb.tmp[i]) + "&rn=100&lm=7&q5=1&q6="+mykeyandweb.web_site[0]);
		for(int i = 0; i < mykeyandweb.tmp.length; i++)
		{
			for(int j = 0; j <= 9 ;j++)
			{
				if(web_inf[j] == '0') continue;
		
				try {
					if(j==0 || j==3 || j==4 || j==5 || j==7 || j==8 || j==9 || j==2)
						doc  =  Jsoup.connect("http://www.baidu.com/s?q1="+java.net.URLEncoder.encode(mykeyandweb.tmp[i])+"&q2=&q3=&q4=&rn=100&lm=7&ct=0&ft=&q5=1&q6="+mykeyandweb.web_site[j]+"&tn=baiduadv").get();
					else if(j == 1 || j == 6)
						doc = Jsoup.connect("http://www.youdao.com/search?q="+java.net.URLEncoder.encode(mykeyandweb.tmp[i])+"+site%3A"+mykeyandweb.web_site[j]+"&ue=utf8&keyfrom=web.index").get();
					//else if(j == 6)
					//	doc  =  Jsoup.connect("http://www.baidu.com/s?q1="+java.net.URLEncoder.encode(mykeyandweb.tmp[i])+"&q2=&q3=&q4=&rn=100&lm=7&ct=0&ft=&q5=&q6="+mykeyandweb.web_site[j]+"&tn=baiduadv").get();
					//Log.e("dd", "dd");
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				Elements es;
				   if(j != 1 && j != 6)
					 es = doc.getElementsByClass("result");
				   else 
					 es = doc.getElementsByClass("res-list");
					for (Element e : es) 
					{
						Map<String, String> map = new HashMap<String, String>();
						map.put("title", e.getElementsByTag("h3").text());
						if(j != 1 && j != 6)
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
						
							//map.put("time",e.getElementsByTag("cite").text()+"w");
						//map.put("inf", mykeyandweb.web_from[j]);
						/*
						String tt =	e.getElementsByTag("a").attr("href").toString();
						try
						{							
							doc1 = Jsoup.connect(tt).get();
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						/*
						if(doc1 != null)
						{
							//Elements eees =doc1.getElementById("date");
							//map.put("inf", eees.text());
							Elements ees = doc1.getElementsByClass("articletext");
							map.put("text",ees.text()) ;
							
						}*/
						
							/*
							map.put("href", "http://cs.hit.edu.cn"
									+ e.getElementsByTag("a").attr("href"));
							map.put("text", e.getElementsByTag("p").text());
							
							
							//flag = 0;
							 * *
							 */
						list.add(map);
						
						
					}
					
					Collections.sort(list, new TestComparator());
					//Collections.sort(list);
					listView.setOnItemClickListener(this);
					listView.setAdapter(new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
							new String[] { "title","inf" }, new int[] {
							android.R.id.text1,android.R.id.text2
					}));
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
		
		TextView mytextview;
		setContentView(R.layout.news_show);
		mytextview = (TextView) this.findViewById(R.id.news_show);
		mytextview.setText(list.get(position).get("text")+list.get(position).get("key"));
		
			
	}
	
	
}
