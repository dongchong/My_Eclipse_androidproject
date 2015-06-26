package com.example.androiddemo;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
public class EatGood extends Activity{
	private ImageView chun,xia,qiu,dong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eatgood);
        chun = (ImageView)findViewById(R.id.imageView1);
        xia = (ImageView)findViewById(R.id.imageView2);
        qiu = (ImageView)findViewById(R.id.imageView3);
        dong = (ImageView)findViewById(R.id.imageView4);
        chun.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(EatGood.this, Chunji.class);
				startActivity(intent);
			}
		});
        xia.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent1 = new Intent();
				intent1.setClass(EatGood.this, Xiaji.class);
				startActivity(intent1);
			}
		});
        qiu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Uri uri = Uri.parse("http://food.39.net/sjys/qjys/");
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
			}
		});
        dong.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Uri uri = Uri.parse("http://food.39.net/sjys/djys/");
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
			}
		});
    }
}
