package com.example.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Jianfeifa extends Activity{
	private String fangfa = null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.jianfeifa);   
		ListView listView = (ListView)findViewById(R.id.list2);
		//定义一个数组
		String[] arr ={"1、黄瓜鸡蛋法" , "2、过午不食法" , "3、不吃正餐法","4、苹果减肥法","5、荷叶减肥法","6、苦瓜减肥法","7、喝水减肥法"};
		//将数组包装ArrayAdapter
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
			this , android.R.layout.simple_list_item_1 , arr);
		//为ListView设置Adapter
		listView.setAdapter(arrayAdapter);	
        
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(Jianfeifa.this, Shoushengonglue.class);
				Bundle bundle = new Bundle();
				fangfa = Jianfeifa.this.getResources().getStringArray(R.array.info)[arg2];
				bundle.putString("NUM", fangfa);
				intent.putExtras(bundle);
				Toast.makeText(Jianfeifa.this, fangfa,  Toast.LENGTH_SHORT).show();
				startActivity(intent);
			}
        	
		});
	}
}
