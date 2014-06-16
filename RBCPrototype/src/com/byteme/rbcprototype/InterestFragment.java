package com.byteme.rbcprototype;

import com.byteme.rbcprototype.SuggestionFragment.SuggestionListArrayAdapter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class InterestFragment extends Fragment implements OnClickListener{
	
	
	
	public InterestFragment(){
		
		
		
	}
	
	@Override
	 public void onActivityCreated(Bundle savedInstanceState) {  
	        super.onActivityCreated(savedInstanceState);  
	     
	        
	 }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 
		 View rootView = inflater.inflate(R.layout.fragment_interest, container, false);
		 
		 
		ImageView img=(ImageView)rootView.findViewById(R.id.travel_btn);
		img.setOnClickListener(this);
	        return rootView;
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i =new Intent (getActivity(),TravelActivity.class);
		
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		startActivity(i);
		
	}
	
	
	
	

}
