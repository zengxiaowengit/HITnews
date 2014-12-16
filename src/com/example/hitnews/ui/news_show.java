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
