package com.example.hitnews.ui;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.hitnews.R;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;

public class col extends Activity implements OnItemClickListener {
	int num;
	String title= "";
	String inf = "";
	String site = "";
	static String tt = "";
	static int zzz = 0;
	SimpleAdapter adapter;
	public  List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	ListView  listview;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);
		SharedPreferences settings = getSharedPreferences("SETTING_Infos",0);
		//num = settings.getInt("col_num", 0);
		//String k = Integer.toString(com.example.hitnews.ui.news_show.col_num);
		
		for(int i =1; i<= com.example.hitnews.ui.news_show.col_num ;i++ )
		{
			Map<String, String> map = new HashMap<String, String>();
			String k = Integer.toString(i);
			title = settings.getString("col"+"title"+k, "");
			map.put("title", title);
			inf = settings.getString("col"+"inf"+k, "");
			map.put("inf", inf);
			site = settings.getString("col"+"site"+k, "");
			map.put("href", site);
			list.add(map);
			
		}
		adapter  = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
				new String[] { "title","inf" }, new int[] {
				android.R.id.text1,android.R.id.text2});
		listview = (ListView) findViewById(R.id.listView1);
		listview.setOnItemClickListener(this);
		listview.setAdapter(adapter);
		
	}
	public void onItemClick(AdapterView parent, View v, int position, long id)
	{
		Document doc1 = null;
		String web_from = null;
		TextView mytextview = null;
		setContentView(R.layout.news_show);
		try
		{		
			tt = list.get(position).get("href");
			doc1 = Jsoup.connect(tt).get();
			 //web_from = list.get(position).get("web_from");
			
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
			Intent i = new Intent(this, news_show.class);
		zzz = 1;
			startActivity(i);
			
			
		
		
			
	}
	protected void onResume() {
        super.onResume();
       // Log.e("aaa", "start onRestart~~~");
       // String k = Integer.toString(list.size());
        /*
        for(int i = 0 ; i<list.size() ;i++)
        {
        	String title = list.get(i).get("title");
        	String inf = list.get(i).get("inf");
        	Log.e(title, inf);
        }
        */
        setContentView(R.layout.begin);
        listview = (ListView) findViewById(R.id.listView1);
        listview.setOnItemClickListener(this);
        listview.setAdapter(adapter);
      // listView.showContextMenu();
       
	
    }
	public static String gethrefzzz()
	{
		return tt;
	}
	}
	

