package com.example.hitnews;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
public class key_choose extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.key_choose);
	}

}