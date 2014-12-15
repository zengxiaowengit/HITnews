package com.example.hitnews.ui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.hitnews.R;
import android.widget.EditText;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.StrictMode;

import com.example.hitnews.logic.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import android.text.Editable; 
public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	static EditText key_edit;
	static  String  mykey;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View beginButton = this.findViewById(R.id.begin_button);
		View sureButton = this.findViewById(R.id.key_sure);
		beginButton.setOnClickListener(this);
		sureButton.setOnClickListener(this);
	
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
			case R.id.key_sure:
			
			key_edit = (EditText) findViewById(R.id.mykey);
			mykey = key_edit.getText().toString();
			Log.e("aa", mykey);
			
			break;
			
			
		
			
		}
			
	}
	public  static String getkey()
	{
		return mykey;
	}
}