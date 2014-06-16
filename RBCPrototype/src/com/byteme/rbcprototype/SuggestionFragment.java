package com.byteme.rbcprototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class SuggestionFragment extends Fragment implements OnClickListener {
	
	
	
	public SuggestionFragment(){
		
		
		
	}
	
	@Override
	 public void onActivityCreated(Bundle savedInstanceState) {  
	        super.onActivityCreated(savedInstanceState);  
	        
	        String[] values = new String[] { "gro","tra","ent","child"};
	        ListView listView = (ListView) getActivity().findViewById(R.id.suggestion_listview);  
			 
			 SuggestionListArrayAdapter adapter=new SuggestionListArrayAdapter(getActivity(),values);
			 
			 listView.setAdapter(adapter);
	        
	 }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 View rootView = inflater.inflate(R.layout.fragment_suggesions, container, false);
		
		
	     return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	
	public class SuggestionListArrayAdapter extends ArrayAdapter<String> {
		  private final Context context;
		  private final String[] values;

		  public SuggestionListArrayAdapter(Context context, String[] values) {
		    super(context, R.layout.suggestion_listview_item_row, values);
		    this.context = context;
		    this.values = values;
		  }

		  @Override
		  public View getView(int position, View convertView, ViewGroup parent) {
		    LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    View rowView = inflater.inflate(R.layout.suggestion_listview_item_row, parent, false);
		    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		    // change the icon for Windows and iPhone
		    String s = values[position];
		    
		    if (s.startsWith("gro")) {
		      imageView.setImageResource(R.drawable.suggestiongrocery);
		    } else if(s.startsWith("tra")) {
		      imageView.setImageResource(R.drawable.suggestiontravel);
		    }else if(s.startsWith("ent")){
		     imageView.setImageResource(R.drawable.suggestionent);
		    }else {
		    	
		    	 imageView.setImageResource(R.drawable.suggestionchild);
		    }

		    return rowView;
		  }
		} 
	

}
