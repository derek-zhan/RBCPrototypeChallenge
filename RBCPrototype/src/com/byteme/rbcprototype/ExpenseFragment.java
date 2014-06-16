package com.byteme.rbcprototype;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class ExpenseFragment extends Fragment implements OnClickListener {
	
	
	public ExpenseFragment(){
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 
		 View rootView = inflater.inflate(R.layout.fragment_analyze, container, false);
		 ImageButton grocery_btn=(ImageButton)rootView.findViewById(R.id.grocery_btn);
		 grocery_btn.setOnClickListener(this);
	        return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		
		case R.id.grocery_btn:{
			
			Intent intent =new Intent(getActivity(),TransactionListActivity.class);
			
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			startActivity(intent);
			
		}
			
		
		
		
		
		}
		
		
	}
	
	


}