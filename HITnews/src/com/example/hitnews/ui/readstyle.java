package com.example.hitnews.ui;
import java.util.HashMap;


import java.util.Calendar;
import android.content.SharedPreferences;
import com.example.hitnews.R;
import android.widget.CheckBox;
import android.support.v7.app.ActionBarActivity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class readstyle extends ActionBarActivity {
	static int mode = 0;
	Button style_sure;
	CheckBox pic;
	CheckBox text;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readstyle);
		style_sure = (Button) findViewById(R.id.style_sure);
		style_sure.setOnClickListener(style_sure_listener);
		pic = (CheckBox) findViewById(R.id.pic);
		text = (CheckBox) findViewById(R.id.text);
		if(mode == 0)
			pic.setChecked(true);
		else if(mode == 1)
			text.setChecked(true);
	}
	 private Button.OnClickListener style_sure_listener = new Button.OnClickListener()
	 { 
		 public void onClick(View v)
		 {
			 if(pic.isChecked() )
			 {
				 mode = 0;
			 }
			 else if(text.isChecked())
			 {
				 mode = 1;
			 }
			 SharedPreferences settings = getSharedPreferences("SETTING_Infos",0);
				settings.edit().putInt("mode", mode).commit();
			 finish();
		 }
		
	 };
	static int getmode()
	{
		return mode;
	}

}