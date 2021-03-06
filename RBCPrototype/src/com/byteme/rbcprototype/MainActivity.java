package com.byteme.rbcprototype;

import com.facebook.Session;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.os.Build;

import com.facebook.*;
import com.facebook.model.*;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends Activity implements OnClickListener,MyMapFragment.MapCallback{

	  MapFragment map;
	  Activity self;
	  ProgressBar pb;
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		self=this;
		
		ImageButton fb_log_btn=(ImageButton) findViewById(R.id.fb_login);
		fb_log_btn.setOnClickListener(this);
		ImageButton rbc_log_btn=(ImageButton) findViewById(R.id.rbc_login);
		rbc_log_btn.setOnClickListener(this);
		pb=(ProgressBar)findViewById(R.id.progressBar1);
		pb.setVisibility(View.GONE);
		
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.fb_login:{
			
					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setMessage("Do you authorize this app to use your Facebook account data?")
						.setTitle("Authorization Required");
			
					builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							pb.setVisibility(View.VISIBLE );
							FacebookLogin();
							//pb.setVisibility(View.VISIBLE);
							// User clicked OK button
						}
					});
					builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							// User cancelled the dialog
						}
					});
					// Set other dialog properties


						// Create the AlertDialog
					builder.create().show();
			
					break;
		
		}
		
		
		case R.id.rbc_login:{
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Do you authorize this app to use your RBC bank account data?")
				.setTitle("Authorization Required");
	
			builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {   
					
					RBCLogin();
					// User clicked OK button
				}
			});
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					// User cancelled the dialog
				}
			});
			// Set other dialog properties


				// Create the AlertDialog
			builder.create().show();
	
			break;
			
		}
		
		}
		
	}
	
	
	public void RBCLogin(){
		
		
		Intent i =new Intent(self.getApplicationContext(),MenuActivity.class);
        startActivity(i);
		
	}
	
	public void FacebookLogin(){
		
		 Session.openActiveSession(this, true, new Session.StatusCallback() {

		      // callback when session changes state
		      @Override
		      public void call(Session session, SessionState state, Exception exception) {
		        if (session.isOpened()) {

		          // make request to the /me API
		          Request.newMeRequest(session, new Request.GraphUserCallback() {

		            // callback after Graph API response with user object
		            @Override
		            public void onCompleted(GraphUser user, Response response) {
		              if (user != null) {
		            	Log.v("MainActivity","login with facebook");
		            	pb.setVisibility(View.INVISIBLE );
		                Intent i =new Intent(self.getApplicationContext(),MenuActivityFacebook.class);
		                startActivity(i);
		                
		              }
		            }
		          }).executeAsync();
		        }
		      }
		    });
		
	}

	@Override
	public void onMapReady(GoogleMap map) {
		// TODO Auto-generated method stub
		
	}
	
	

}
