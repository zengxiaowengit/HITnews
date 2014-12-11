package com.example.hitnews.ui;
import com.example.hitnews.pagedeal.Pagedownload;
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
import com.example.hitnews.user.web_from;
public class begin extends Activity implements OnItemClickListener {

	
	Document doc,doc1;
	public List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	public String key ; 
	public String t;
	public String web;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);
		 web = web_choose.getweb();
		 key = key_choose.getkey();
		 Log.e("a",key);
		 Log.e("a", web);
		 
		
		//load();
	}
	
	protected void load() 
	{
		
		try {
				
				doc  =  Jsoup.parse(new URL("http://www.youdao.com/search?q="+ java.net.URLEncoder.encode(key) + "+site%3Atoday.hit.edu.cn"), 5000);
			
			
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			ListView listView = (ListView) findViewById(R.id.listView1);
	
				
			Elements es = doc.getElementsByClass("res-list");
			
			
			for (Element e : es) 
			{
				Map<String, String> map = new HashMap<String, String>();
				//	Elements e_title = e.getElementsByClass("title-and-meta");
				map.put("title", e.getElementsByTag("a").text());
				
				String tt =	e.getElementsByTag("a").attr("href").toString();
				try
				{
					
				doc1 = Jsoup.connect(tt).get();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(doc1 != null)
				{
					//Elements eees =doc1.getElementById("date");
					//map.put("inf", eees.text());
					Elements ees = doc1.getElementsByClass("articletext");
					map.put("text",ees.text()) ;
					
				}
					/*
					map.put("href", "http://cs.hit.edu.cn"
							+ e.getElementsByTag("a").attr("href"));
					map.put("text", e.getElementsByTag("p").text());
					
					
					//flag = 0;
					 * *
					 */
				list.add(map);
				
			}
			
		
			listView.setOnItemClickListener(this);
			listView.setAdapter(new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
					new String[] { "title","inf" }, new int[] {
					android.R.id.text1,android.R.id.text2
			}));
			
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
