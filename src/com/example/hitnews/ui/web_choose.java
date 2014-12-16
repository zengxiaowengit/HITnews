package com.example.hitnews.ui;
import com.example.hitnews.R;
import android.view.View;
import android.os.Bundle;
import android.widget.CheckBox;
import android.app.Activity;
import android.widget.Button;
public class web_choose extends Activity
{
	 CheckBox web_jwc;
	 CheckBox web_cs;
	 CheckBox web_today;
	 CheckBox web_math;
	 static String web_res = "";
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
		    
		 web_sure = (Button)findViewById(R.id.web_sure);  
		 web_sure.setOnClickListener(web_sure_listener);  
	}
	 private Button.OnClickListener web_sure_listener = new Button.OnClickListener()
	 { 
		 public void onClick(View v)
		 {
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
			 finish();
		 }
	 };
	 public static String getweb()
	 {
		 return web_res;
	 }

}