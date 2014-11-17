<<<<<<< HEAD
package com.example.hitnews.ui;
import com.example.hitnews.pagedeal.Pagedownload;
import com.example.hitnews.R;

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

public class begin extends Activity implements OnItemClickListener {

	Document doc;
	public List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	public String key = "学院新闻" ; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);

		//findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			//@Override
			//public void onClick(View v) {
				load();
			//}
		//});
	}

	protected void load() {
		try {
			doc = Jsoup.connect("http://cs.hit.edu.cn").get();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		int flag = 0;
		if(doc == null)
			Log.e("aaa", "bbb");
		Elements es = doc.getElementsByClass("node-article");
		
		for (Element e : es) {
			Elements e_key = e.getElementsByClass("field-name-field-news-fenlei");
			for(Element ee : e_key)
			{
				if(ee.getElementsByTag("a").text().equals(key))
				flag = 1;
			}
			if(flag == 1)
			{
				Map<String, String> map = new HashMap<String, String>();
				Elements e_title = e.getElementsByClass("title-and-meta");
				
				for(Element ee : e_title)
				{
					map.put("title", ee.getElementsByTag("a").text());
				}
				for(Element ee : e_key)
				{
					map.put("key", ee.getElementsByTag("a").text());
				}
				map.put("href", "http://cs.hit.edu.cn"
						+ e.getElementsByTag("a").attr("href"));
				map.put("text", e.getElementsByTag("p").text());
				
				list.add(map);
				flag = 0;
			}
		}
		
		
		listView.setOnItemClickListener(this);
		listView.setAdapter(new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
				new String[] { "title","href" }, new int[] {
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
=======
package com.example.hitnews.ui;
import com.example.hitnews.pagedeal.Pagedownload;
import com.example.hitnews.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

public class begin extends ActionBarActivity
{
	private TextView news;
		@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		//String s=Pagedownload.getHtmlData("http://www.baidu.com", "GB2312");
		setContentView(R.layout.begin);
	//	new Thread(connectRunnable).start();
		news =(TextView) findViewById(R.id.news_show);
		news.setText("敬请期待");
		
	}
/*
	Runnable connectRunnable = new Runnable() 
	{
		public void run() 
		{ 
			String s=Pagedownload.getHtmlData("http://www.baidu.com", "GB2312");
		}
	};
	*/
}
>>>>>>> 9a21edb220d946db15c24462785be75aefa98833
