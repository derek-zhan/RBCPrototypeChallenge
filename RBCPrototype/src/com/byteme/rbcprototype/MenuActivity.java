package com.byteme.rbcprototype;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MenuActivity extends FragmentActivity implements OnClickListener {

	
	private String[] mNavigationDrawerItemTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private GoogleMap gm;
	public  FragmentActivity self=this;
	public SupportMapFragment mapFrag;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	
	ActionBarDrawerToggle mDrawerToggle;
	
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		
		mapFrag = new SupportMapFragment() {
            @Override
            public void onActivityCreated(Bundle savedInstanceState) {
                super.onActivityCreated(savedInstanceState);
                gm = mapFrag.getMap();
                
            }
        };
		
        if(gm==null){
			Log.d("MenuActivity","map is null");
		}
		
		
		
		ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[4];
		
		drawerItem[0] =new ObjectDrawerItem(R.drawable.icon_expenses,"Expense");
		drawerItem[1] = new ObjectDrawerItem(R.drawable.icon_cashflow, "Cash Flow");
		drawerItem[2] = new ObjectDrawerItem(R.drawable.icon_suggestions, "suggestions");
		drawerItem[3] = new ObjectDrawerItem(R.drawable.suggestion_arbie_small_filled,"");
		
		
		
		DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem,0);
		
		mDrawerList.setAdapter(adapter);
		
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		mTitle = mDrawerTitle = getTitle();
		
		mDrawerToggle = new ActionBarDrawerToggle(
		        this,
		        mDrawerLayout,
		        R.drawable.ic_drawer, 
		        R.string.drawer_open, 
		        R.string.drawer_close 
		        ) {
		    
		    /** Called when a drawer has settled in a completely closed state. */
		    public void onDrawerClosed(View view) {
		        super.onDrawerClosed(view);
		        getActionBar().setTitle(mTitle);
		    }
		 
		    /** Called when a drawer has settled in a completely open state. */
		    public void onDrawerOpened(View drawerView) {
		        super.onDrawerOpened(drawerView);
		        getActionBar().setTitle(mDrawerTitle);
		    }
		};
		 
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		 
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		if (savedInstanceState == null) {
            selectItem(0);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    
	   if (mDrawerToggle.onOptionsItemSelected(item)) {
	       return true;
	   }
	   
	   return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void setTitle(CharSequence title) {
	    mTitle = title;
	    getActionBar().setTitle(mTitle);
	}
	
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
	   
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			selectItem(position);
		}
	    
	}
	
	 
	private void selectItem(int position) {
	    
	    Fragment fragment = null;
	    
	    switch (position) {
	    case 0:
	        fragment = new ExpenseFragment();
	        break;
	    case 1:
	    	fragment = new CashFlowFragment();
	        break;
	    case 2:
	    	fragment =new SuggestionFragment();
	    	break;
	    case 3:
	    	fragment =new RewardFragment();
	    	break;
	    default:
	        break;
	    }
	    if (fragment != null ) {
	    	
	        FragmentManager fragmentManager = getFragmentManager();
	        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
	        //mDrawerLayout.setVisibility(View.INVISIBLE);
	        mDrawerList.setItemChecked(position, true);
	        mDrawerList.setSelection(position);
	        setTitle(mNavigationDrawerItemTitles[position]);
	        mDrawerLayout.closeDrawer(mDrawerList);
	    	
	    } else {
	        Log.e("MainActivity", "Error in creating fragment");
	    }
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
	
	
	

}
