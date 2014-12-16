package com.example.hitnews.user;
import com.example.hitnews.R;
import android.app.Activity;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.CheckBox;

public class web_from extends Activity
{
	 CheckBox web_jwc;
	 CheckBox web_cs;
	 CheckBox web_today;
	 CheckBox web_math;
	 String web_res = "";
	public  void get_web_inf()
	{
		web_jwc = (CheckBox) findViewById(R.id.web_jwc);
		web_cs = (CheckBox) findViewById(R.id.web_cs);
		web_today = (CheckBox) findViewById(R.id.web_today);
		web_math = (CheckBox) findViewById(R.id.web_math);
		if(web_jwc.isChecked())
			web_res += "1";
		else web_res += "0";
		if(web_cs.isChecked())
			web_res += "1";
		else web_res += "0";
		if(web_today.isChecked())
			web_res += "1";
		else web_res += "0";
		if(web_math.isChecked())
			web_res += "1";
		else web_res += "0";
	}
	public  String getweb()
	{
		 get_web_inf();
		 return web_res;
	}
}
