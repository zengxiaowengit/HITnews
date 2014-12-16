package com.example.hitnews.ui;
import com.example.hitnews.R;

import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.CheckBox;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.Button;
public class web_choose extends Activity
{
	 CheckBox web_jwc;
	 CheckBox web_cs;
	 CheckBox web_today;
	 CheckBox web_math;
	 CheckBox web_chemeng;
	 CheckBox web_civil;
	 CheckBox web_life;
	 CheckBox web_food;
	 CheckBox web_software;
	 CheckBox web_jzxy;
	 static String web_res = "";
	 static String myweb;
	 Button web_sure;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("CheckBoxAcitiviy");
		setContentView(R.layout.web_choose);
		init();
	}
	public void init()
	{
		 web_jwc = (CheckBox) findViewById(R.id.web_jwc);  
		 web_cs = (CheckBox) findViewById(R.id.web_cs);  
		 web_today = (CheckBox) findViewById(R.id.web_today);  
		 web_math = (CheckBox) findViewById(R.id.web_math);  
		 web_chemeng = (CheckBox) findViewById(R.id.web_chemeng);
		 web_civil = (CheckBox) findViewById(R.id.web_civil);
		 web_life = (CheckBox) findViewById(R.id.web_life);
		 web_food = (CheckBox) findViewById(R.id.web_food);
		 web_software = (CheckBox) findViewById(R.id.web_software);
		 web_jzxy = (CheckBox) findViewById(R.id.web_jzxy);
		 web_sure = (Button)findViewById(R.id.web_sure);  
		 web_sure.setOnClickListener(web_sure_listener);  
		// web_res = "";
		
			Log.e("www", web_res);
			char web_web[] = web_res.toCharArray();
			if(web_res.length() == 10 )
			{
			for(int i = 0 ;i <= 9 ;i++)
			{
				if(web_web[i] == '1')
				{
					if(i == 0)
					{
						web_jwc.setChecked(true);
					}
					else if(i == 1)
					{
						web_cs.setChecked(true);
					}
					else if(i == 2)
					{
						web_today.setChecked(true);
					}
					else if( i == 3)
					{
						web_math.setChecked(true);
					}
					else if( i == 4)
					{
						web_chemeng.setChecked(true);
					}
					else if(i == 5)
					{
						web_civil.setChecked(true);
						
					}
					else if(i == 6)
					{
						web_life.setChecked(true);
					}
					else if(i == 7)
					{
						web_food.setChecked(true);
					}
					else if(i == 8)
					{
						web_software.setChecked(true);
					}
					else 
						web_jzxy.setChecked(true);
				}
			}
					
					
			}
			
	}
	 private Button.OnClickListener web_sure_listener = new Button.OnClickListener()
	 { 
		 public void onClick(View v)
		 {
			 web_res="";
			 if(web_today.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 
			 if(web_cs.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_jwc.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_chemeng.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_civil.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_life.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_math.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_food.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_software.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 if(web_jzxy.isChecked())
				 web_res += "1";
			 else web_res += "0";
			 myweb = web_res;
			 SharedPreferences settings = getSharedPreferences("SETTING_Infos",0);
				settings.edit().putString("web", web_res).commit();
			 finish();
		 }
	 };
	 public static String getweb()
	 {
		 return myweb;
	 }

}