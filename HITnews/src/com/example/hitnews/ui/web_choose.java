package com.example.hitnews.ui;
import com.example.hitnews.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;
public class web_choose extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.web_choose);
	}

}