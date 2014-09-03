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
		news.setText("¾´ÇëÆÚ´ý");
		
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
