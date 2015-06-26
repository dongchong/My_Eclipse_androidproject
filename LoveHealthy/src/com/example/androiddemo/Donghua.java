package com.example.androiddemo;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

@SuppressLint("HandlerLeak")
public class Donghua extends Activity{

	private static final int TO_THE_END = 0;// 到达最后一张
	private static final int LEAVE_FROM_END = 1;// 离开最后一张

	private int[] ids = { R.drawable.img1, R.drawable.img2,
			R.drawable.img3, R.drawable.img4, 
			R.drawable.img5, R.drawable.img6 };
			
	private List<View> guides = new ArrayList<View>();
	private ViewPager pager;
	private ImageView open;
	private ImageView curDot;
	private int offset;// 位移量
	private int curPos = 0;// 记录当前的位置

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.donghua);

		for (int i = 0; i < ids.length; i++) {
			ImageView iv = new ImageView(this);
			iv.setImageResource(ids[i]);
			ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.FILL_PARENT,
					ViewGroup.LayoutParams.FILL_PARENT);
			iv.setLayoutParams(params);
			iv.setScaleType(ScaleType.FIT_XY);
			guides.add(iv);
		}

		curDot = (ImageView) findViewById(R.id.cur_dot);
		open = (ImageView) findViewById(R.id.open);
		curDot.getViewTreeObserver().addOnPreDrawListener(
			new OnPreDrawListener() {
				@Override
				public boolean onPreDraw() {
					offset = curDot.getWidth();
					return true;
			}
		});
		open.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(Donghua.this, MainActivity.class);
				startActivity(in);
			}
		});
		GuidePagerAdapter adapter = new GuidePagerAdapter(guides);
		pager = (ViewPager) findViewById(R.id.contentPager);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				moveCursorTo(arg0);
				if (arg0 == ids.length - 1) {// 到最后一张了
					handler.sendEmptyMessageDelayed(TO_THE_END, 500);
				} else if (curPos == ids.length - 1) {
					handler.sendEmptyMessageDelayed(LEAVE_FROM_END, 100);
				}
				curPos = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
			
		});
	}

	/**
	 * 移动指针到相邻的位置
	 * 
	 * @param position
	 * 		  		指针的索引值
	 * */
	private void moveCursorTo(int position) {
		TranslateAnimation anim = new TranslateAnimation(offset*curPos, offset*position, 0, 0);
		anim.setDuration(300);
		anim.setFillAfter(true);
		curDot.startAnimation(anim);
	}

	Handler handler = new Handler() {
		@SuppressLint("HandlerLeak")
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == TO_THE_END)
				open.setVisibility(View.VISIBLE);
			else if (msg.what == LEAVE_FROM_END)
				open.setVisibility(View.GONE);
		}
	};
}
