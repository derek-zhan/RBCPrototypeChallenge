package com.byteme.rbcprototype;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerItemCustomAdapter extends ArrayAdapter<ObjectDrawerItem> {
	 
    Context mContext;
    int layoutResourceId;
    ObjectDrawerItem data[] = null;
    int loginType;// 0 for bank account login , 1 for facebook login
    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, ObjectDrawerItem[] data,int loginType) {
 
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
        this.loginType=loginType;
        
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
        View listItem = convertView;
 
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);
        
        ImageView imageViewIcon = null;
        TextView textViewName=null;
        
        if(this.loginType==0){
        
        if(position<3){
        	
        		imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        		textViewName = (TextView) listItem.findViewById(R.id.textViewName);
         
        	}else{
        		imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIconRight);
        		textViewName = (TextView) listItem.findViewById(R.id.textViewNameLeft);	
        	
        	}
        }else if (this.loginType==1){
        	
        	if(position<2)
        	{
        		imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
                textViewName = (TextView) listItem.findViewById(R.id.textViewName);
        	}else{
        		
        		imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIconRight);
                textViewName = (TextView) listItem.findViewById(R.id.textViewNameLeft);
        	}
        	
        	
        }
        
        ObjectDrawerItem folder = data[position];
        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);
        
        return listItem;
    }
    
 

}
