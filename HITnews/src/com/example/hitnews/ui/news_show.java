<<<<<<< HEAD
package com.example.hitnews.ui;

import android.webkit.WebViewClient;
import com.example.hitnews.R;
import android.webkit.WebSettings;  
import android.webkit.WebView; 
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.CheckBox;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
public class news_show extends Activity
{
	
	static String mynews = "";
	static String myhref = "";
	static int col_num ;
	String inf_news = "";
	String title_news = "";
	TextView mynewshow;
	WebView  wv;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("read_news");
		
		if(com.example.hitnews.ui.readstyle.mode == 0)
		{
			setContentView(R.layout.webview);
			wv = (WebView) findViewById(R.id.webview);
			if(com.example.hitnews.ui.col.zzz == 1)
			{
				mynews = com.example.hitnews.ui.col.gethrefzzz();
				com.example.hitnews.ui.col.zzz = 0;
			}
			else 
			{
			mynews = com.example.hitnews.ui.begin.getmyhref();
			}
			wv.loadUrl(mynews);
		//mynewshow = (TextView) findViewById(R.id.news_show);
		//mynews = com.example.hitnews.u
			wv.setWebViewClient(new WebViewClient(){
	           @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
	             view.loadUrl(url);
	            return true;
	        }
	       });
		}
		else if ( com.example.hitnews.ui.readstyle.mode == 1)
		{
			setContentView(R.layout.news_show);
			mynewshow = (TextView) findViewById(R.id.news_show);
			mynews =com.example.hitnews.ui.begin.getmynews();
			mynewshow.setText(mynews);
			
		}
		myhref = com.example.hitnews.ui.begin.getmyhref();
		inf_news = com.example.hitnews.ui.begin.getinf_news();
		title_news = com.example.hitnews.ui.begin.gettitle_news();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.share, menu);
		return true;
	}
	    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId())
		{
			case R.id.share:
				
				 
					 Intent intent=new Intent(Intent.ACTION_SEND);
					 
					 intent.setType("image/*");
					
					 intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
					
					 intent.putExtra(Intent.EXTRA_TEXT, "该信息来源于我的安卓程序测试"+myhref );
					//intent.putExtra(Intent.E )
					 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					 startActivity(Intent.createChooser(intent, getTitle()));		
			break;	
			case R.id.col:
				col_num++;
				SharedPreferences settings = getSharedPreferences("SETTING_Infos",0);
				
				String kkk = Integer.toString(col_num);
				settings.edit().putString("col"+"title"+kkk, title_news).commit();
				settings.edit().putString("col"+"inf"+kkk, inf_news).commit();
				settings.edit().putString("col"+"site"+kkk, myhref).commit();
				settings.edit().putInt("col_num", col_num).commit();
				break;
				
				
			
				
		}
		return true;
	}      
}
=======
package com.example.hitnews.ui;

import com.example.hitnews.R;

import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.CheckBox;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
public class news_show extends Activity
{
	
	static String mynews = "";
	TextView mynewshow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("read_news");
		setContentView(R.layout.news_show);
		mynewshow = (TextView) findViewById(R.id.news_show);
		mynews = com.example.hitnews.ui.begin.getmynews();
		mynewshow.setText(mynews);
		//init();
	}
}
>>>>>>> e35f1071a7c2ae75a5d68c7b12869dfbc0da3f81
