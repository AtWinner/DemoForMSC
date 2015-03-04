package com.example.demoformsc;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private PullToRefreshScrollView mPullToRefreshScrollView;
	private ScrollView mScrollView;
	private LinearLayout SrcollLinear;
	private HorizontalScrollView horizontalScrollView;
	private LinearLayout horizontalLinear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setParams();
		bindEvent();
	}
	private void init()
	{
		mPullToRefreshScrollView = (PullToRefreshScrollView)findViewById(R.id.pull_refresh_list);
		mPullToRefreshScrollView.setMode(Mode.BOTH);
		mScrollView = mPullToRefreshScrollView.getRefreshableView();
		horizontalScrollView = (HorizontalScrollView)findViewById(R.id.horizontalScrollView);
		horizontalScrollView.smoothScrollTo(100, 0);
		horizontalLinear = (LinearLayout)findViewById(R.id.horizontalLinear);
//		horizontalLinear.scrollTo(1000, 0);
		new Handler().postDelayed((
				new Runnable() 
				{ 
					@Override 
					public void run() 
					{ 
						horizontalScrollView.scrollTo(horizontalScrollView.getLeft()-100,0); 
						} 
					}),5);
	}
	private void setParams()
	{
		
	}
	private void bindEvent()
	{
		mPullToRefreshScrollView.setOnRefreshListener(new com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2<ScrollView>() {
			@Override
			public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) 
			{
				Toast.makeText(MainActivity.this, "text", Toast.LENGTH_SHORT).show();
			}
			@Override
			public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) 
			{
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_main, container,
					false);
			return rootView;
		}
	}

}
