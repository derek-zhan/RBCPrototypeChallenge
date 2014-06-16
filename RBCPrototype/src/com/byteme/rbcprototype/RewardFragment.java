package com.byteme.rbcprototype;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class RewardFragment extends Fragment{
	
	
	
	public RewardFragment(){
		
		
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 
		 View rootView = inflater.inflate(R.layout.fragment_reward, container, false);
		
	        return rootView;
	}

}
