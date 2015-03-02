package com.example.adapter;

import com.example.demoformsc.R;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class ListViewAdapter extends BaseAdapter  {
	private LayoutInflater inFlater;
	private int resource;// 绑定的一个条目界面的id，此例中即为item.xml
	ViewHolder holder = null;
	public  ListViewAdapter(Context context, int res)
	{
		inFlater = LayoutInflater.from(context);
		resource = res;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) 
	{
		if (contentView == null)
		{// 显示第一页的时候convertView为空
			contentView = inFlater.inflate(resource, null);// 生成条目对象
			holder = new ViewHolder();
			holder.myScrollView = (HorizontalScrollView)contentView.findViewById(R.id.myScrollView);
		}
		new Handler().postDelayed((new Runnable() 
		{ 
			@Override 
			public void run() { 
				holder.myScrollView.scrollTo(-100,0); 
				} 
			}),5);
		return contentView;
	}
	private class ViewHolder
	{
		HorizontalScrollView myScrollView;
	}
	
}
