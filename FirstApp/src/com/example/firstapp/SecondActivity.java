package com.example.firstapp;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(new CustomView(this));
		
		
		
		
	}

}
