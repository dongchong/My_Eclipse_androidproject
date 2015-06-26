package com.example.androiddemo;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Report extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.report);
        findView();
        show();
        setListeners();
    }
    private ImageView back;
    private ImageView next;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
	private void findView() {
		// TODO 自动生成的方法存根
		back = (ImageView)findViewById(R.id.imageView6);
		next = (ImageView)findViewById(R.id.imageView7);
		textView1 = (TextView)findViewById(R.id.imageView1);
		textView2 = (TextView)findViewById(R.id.imageView2);
		textView3 = (TextView)findViewById(R.id.imageView3);
	}

	private void setListeners() {
		// TODO 自动生成的方法存根
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(Report.this, Shoushenjihua.class);
				startActivity(in);
			}
		});
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(Report.this,Jianfeifa.class);
				startActivity(in);
			}
		});
	}
	private void show(){
		DecimalFormat nf = new DecimalFormat("0.00");
		Bundle bundle = this.getIntent().getExtras();
		double xian = Double.parseDouble(bundle.getString("XIANZAI"));
		double mu = Double.parseDouble(bundle.getString("MUBIAO"));
		String riqi = bundle.getString("RIQI");
		textView1.setText(getString(R.string.xianzai) +nf.format(xian)+"kg");
		textView2.setText(getString(R.string.mubiao) +nf.format(mu)+"kg");
		textView3.setText(getString(R.string.yuefen) +riqi);
	}
}
