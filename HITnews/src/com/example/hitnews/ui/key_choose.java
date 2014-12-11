package com.example.hitnews.ui;
import com.example.hitnews.R;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.CheckBox;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
public class key_choose extends Activity implements OnClickListener
{
	String mykeyshowstringbegin = "现在定制的关键词是：";
	static String mykeyshowstring = ""; 
	Button new_key;
	Button delete_key;
	Button finish_key;
	TextView mykeyshow;
	EditText mynewkey;
	int mykeynum = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setTitle("CheckBoxAcitiviy");
		setContentView(R.layout.key_choose);
		new_key = (Button) findViewById(R.id.new_key);
		delete_key = (Button) findViewById(R.id.delete_key);
		finish_key = (Button) findViewById(R.id.finish_key);
		mykeyshow = (TextView) findViewById(R.id.my_key);
		mynewkey = (EditText) findViewById(R.id.my_new_key);
		new_key.setOnClickListener(this);
		delete_key.setOnClickListener(this);
		finish_key.setOnClickListener(this);
		
	}
	public void onClick(View v)
	{
		switch(v.getId())
		{
			
			case R.id.finish_key:
			
				finish();
			
				break;
			case R.id.new_key:
				mykeyshowstring += mynewkey.getText().toString();
				
			//Log.e("aa", mykey);
				if(mykeynum == 0)
					mykeyshow.setText(mykeyshowstringbegin+mykeyshowstring);
				else 
					mykeyshow.setText(mykeyshowstringbegin+" "+mykeyshowstring);
				mykeynum++;
				break;
			case R.id.delete_key:
				mykeyshowstring = "";
				mykeyshow.setText("你还没有订阅关键词");
				mykeynum = 0;
				break;
					
		}
	}
	public static String getkey()
	{
		return mykeyshowstring;
	}
}