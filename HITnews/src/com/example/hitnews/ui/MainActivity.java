package com.example.hitnews.ui;

import android.app.AlertDialog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import com.example.hitnews.R;
import android.widget.EditText;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.StrictMode;
import java.util.ArrayList;
import com.example.hitnews.logic.*;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
//import android.text.Editable; 
public class MainActivity extends ActionBarActivity implements OnClickListener {
	update_load myupdate_load = new update_load();
	static EditText key_edit;
	static  String  mykey;
	Timer timer;
	int time_flag = 0;
	int m =0;
	static  int  read = 0;
	int is_used;
	private NotificationManager notificationManager;
	List<Map<String ,String>> list1,list2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View beginButton = this.findViewById(R.id.begin_button);
		//View sureButton = this.findViewById(R.id.key_sure);
		beginButton.setOnClickListener(this);
	//	sureButton.setOnClickListener(this);
		if(time_flag == 0 )
		{
			updatenews();
			time_flag = 1;
		}
		notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		SharedPreferences settings = getSharedPreferences("SETTING_Infos",0);
		mykey = settings.getString("key", "");
		is_used =  settings.getInt("is_used", 0);
		if(is_used == 0)
		{
			is_used = 1;
			settings.edit().putInt("is_used", is_used).commit();
			first_use();
		}
		com.example.hitnews.ui.key_choose.mykeyshowstring = mykey;
		getkey();
		 //SharedPreferences settings = getSharedPreferences("SETTING_Infos",0);
			com.example.hitnews.ui.web_choose.myweb=settings.getString("web", "");
			com.example.hitnews.ui.web_choose.web_res = settings.getString("web", "");
		//news =(TextView) begin. findViewById(R.id.news_show);
		
	//	View userButton = this.findViewById(R.id.user_button);
		//userButton.setOnClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId())
		{
			case R.id.web_choose:
			startActivity(new Intent(this,web_choose.class));
			break;	
			case R.id.key_choose:
			startActivity(new Intent(this,key_choose.class));
			break;
			case R.id.log:
			startActivity(new Intent(this, login.class));
			break;
			case R.id.register:
			startActivity(new Intent(this, register.class));
			break;
			case R.id.feedback:
			startActivity(new Intent(this, feedback.class));
		}
		return true;
	}
	public void onClick(View v)
	{
		Intent i;
		switch(v.getId())
		{
			//case R.id.user_button:
			//i = new Intent(this, login.class);
			//startActivity(i);
			//break;
			case R.id.begin_button:
			i = new Intent(this, begin.class);
			//news.setText("www");
			startActivity(i);
			break;
			
			
			
		
			
		}
			
	}
	public  static void getkey()
	{
		com.example.hitnews.ui.key_choose.mykeyshowstring = mykey;
	}
	public void updatenews()
	{
		
		
		timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run()
			{
				
				if(read == 1)
				{
				Log.e("ww", "update");
				myupdate_load.init();
				list1 = com.example.hitnews.ui.begin.getmylist();
				list2 = com.example.hitnews.logic.update_load.getmylist();
				String time1 = list1.get(0).get("time");
				String time2 = list2.get(0).get("time");
				//String k = Integer.toString(list1.size());
				//String kk = Integer.toString(list2.size());
				//if(big(time2,time1))
				//Log.e("ee", time1+" "+time2);
				//Log.e("ee", k+" "+kk);
				if(list1 != null && list2 != null)
				if((list1.size() < list2.size()) || big(time2,time1))
				{
					Log.e("mm", "update");
					//String k = Integer.toString(list1.size());
					//String kk = Integer.toString(list2.size());
					//Log.e("ee", k+" "+kk);
					 showNotification("有新的新闻啦", "新的新闻哟",
						     "快刷新看新的新闻啦", R.drawable.addmood_poi_icon,
						      R.drawable.addmood_poi_icon);
				}
				myupdate_load.clear();
				}
			
			}	
			
		}, 0,5000);
		
	}
	boolean big(String a,String b)
	{
		char aa[] = a.toCharArray();
		char bb[] = b.toCharArray();
		for(int i = 0 ;i<aa.length;i++)
		{
			if(aa[i] > bb[i])
			
			return true;
		}
		return false;
	}
	
	 private void showNotification(String tickerText, String contentTitle,
			   String contentText, int id, int resId)
			 {
			  Notification notification = new Notification(resId,
			    tickerText, System.currentTimeMillis());
			  PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
			    getIntent(), 0);
			  notification.setLatestEventInfo(this, contentTitle, contentText,
			    contentIntent);
			  notificationManager.notify(id, notification);
			 }
	 void first_use()
	 {
		 new AlertDialog.Builder(MainActivity.this)
		 .setTitle("HITnews").setMessage("欢迎使用，第一次使用的时候，请先右键设置关键词和新闻来源网站哟~感谢使用").setPositiveButton("知道了", null).show();
	 }
	
}
