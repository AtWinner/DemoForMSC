package com.example.demoformsc;

import com.example.adapter.ListViewAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private PullToRefreshListView mPullRefreshListView;
	private ListView mListView;
	
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
		mPullRefreshListView = (PullToRefreshListView)findViewById(R.id.pull_refresh_list);
		mListView = mPullRefreshListView.getRefreshableView();
		
		ListViewAdapter adapter = new ListViewAdapter(MainActivity.this, R.layout.list_item);
		 mListView.setAdapter(adapter);
	}
	private void setParams()
	{
		mPullRefreshListView.setMode(Mode.BOTH);
	}
	private void bindEvent()
	{
		
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
