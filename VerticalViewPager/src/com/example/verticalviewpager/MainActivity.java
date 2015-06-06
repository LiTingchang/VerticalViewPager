package com.example.verticalviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private VerticalViewPager viewPager;
	private List<Integer> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dataList = new ArrayList<Integer>();
		for(int i = 0; i < 10; ++i) {
			dataList.add(i);
		}
		
		viewPager = (VerticalViewPager)findViewById(R.id.vertical_viewpager);
		viewPager.setAdapter(new MyAdapter(dataList));
		
		viewPager.setCurrentItem(2);
	}
	
	private class MyAdapter extends PagerAdapter {
		
		private List<Integer> items;
		
		public MyAdapter(List<Integer> items) {
			this.items = items;
		}

		@Override
		public int getCount() {
			return items == null ? 0 : items.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			final Integer item = items.get(position);
			
			View view = getLayoutInflater().inflate(R.layout.view_pager, null);
			((TextView) view.findViewById(R.id.pager_text)).setText("pager : " + item);
			
			container.addView(view);
			return view;
		}
	}
}
