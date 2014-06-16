package com.byteme.rbcprototype;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class SplashScreenActivity extends Activity {
	
	
    private final static int SPLASH_TIME_OUT=1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				
				Intent i=new Intent(SplashScreenActivity.this,MainActivity.class);
				startActivity(i);
				finish();
			}
		},SPLASH_TIME_OUT);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

	

}
