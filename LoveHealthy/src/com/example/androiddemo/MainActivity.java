package com.example.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setListeners();
	}
	public void init(){
		imageView1 = (ImageView)findViewById(R.id.imageView1);
		imageView2 = (ImageView)findViewById(R.id.imageView2);
		imageView3 = (ImageView)findViewById(R.id.imageView3);
		imageView4 = (ImageView)findViewById(R.id.imageView4);
		imageView5 = (ImageView)findViewById(R.id.imageView5);
		imageView6 = (ImageView)findViewById(R.id.imageView6);
		imageView7 = (ImageView)findViewById(R.id.imageView7);
		imageView8 = (ImageView)findViewById(R.id.imageView8);
		imageView9 = (ImageView)findViewById(R.id.imageView9);
	}
	public void setListeners(){
		imageView1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, BMI.class);
				startActivity(in);
			}
		});
		imageView2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, Shoushenjihua.class);
				startActivity(in);
			}
		});
		imageView3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, EatGood.class);
				startActivity(in);
			}
		});
		imageView4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, Naozhong.class);
				startActivity(in);
			}
		});
		imageView5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, HealthyHelper.class);
				startActivity(in);
			}
		});
		imageView6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, GoodLife.class);
				startActivity(in);
			}
		});
		imageView7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, Caozuojilu.class);
				startActivity(in);
			}
		});
		imageView8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, Help.class);
				startActivity(in);
			}
		});
		imageView9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(MainActivity.this, ForOur.class);
				startActivity(in);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
