package com.example.androiddemo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
public class GoodLife extends Activity{
    private ImageView lovebook;
    private ImageView lovefenxiang;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goodlife);
        lovebook = (ImageView)findViewById(R.id.lovebook);
        lovefenxiang = (ImageView)findViewById(R.id.lovefenxiang);
        lovebook.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(GoodLife.this, LoveBook.class);
				startActivity(intent);
			}
		});
        lovefenxiang.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(GoodLife.this, LoveFenxiang.class);
				startActivity(intent);
			}
		});
    }
}