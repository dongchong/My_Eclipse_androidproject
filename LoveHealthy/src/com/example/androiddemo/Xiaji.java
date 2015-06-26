package com.example.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Xiaji extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiaji);
		ListView listView = (ListView)findViewById(R.id.xiajiyinshi);
		//定义一个数组
		String[] arr ={"暑热天要少吃高蛋白食物" , "炎炎夏日“饮食方”" , "夏季补脾益气多吃樱桃","高温天关注舌尖上的安全","夏天多吃肉感觉更热吗","夏季脾虚者瓜果要少吃","夏天吃凉拌菜 祛暑又健康","夏日饮水讲究技巧"};
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
				switch (arg2) {
				case 0:
					Uri uri = Uri.parse("http://food.39.net/a/130819/4238030.html");
					Intent intent = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(intent);
					break;
				case 1:
					Uri uri1 = Uri.parse("http://food.39.net/a/130809/4232791.html");
					Intent intent1 = new Intent(Intent.ACTION_VIEW,uri1);
					startActivity(intent1);
					break;
				case 2:
					Uri uri2 = Uri.parse("http://food.39.net/a/130808/4232658.html");
					Intent intent2 = new Intent(Intent.ACTION_VIEW,uri2);
					startActivity(intent2);
					break;
				case 3:
					Uri uri3 = Uri.parse("http://food.39.net/a/130808/4232621.html");
					Intent intent3 = new Intent(Intent.ACTION_VIEW,uri3);
					startActivity(intent3);
					break;
				case 4:
					Uri uri4 = Uri.parse("http://food.39.net/a/130807/4232156.html");
					Intent intent4 = new Intent(Intent.ACTION_VIEW,uri4);
					startActivity(intent4);
					break;
				case 5:
					Uri uri5 = Uri.parse("http://food.39.net/a/130806/4231114.html");
					Intent intent5 = new Intent(Intent.ACTION_VIEW,uri5);
					startActivity(intent5);
					break;
				case 6:
					Uri uri6 = Uri.parse("http://food.39.net/a/130805/4230556.html");
					Intent intent6 = new Intent(Intent.ACTION_VIEW,uri6);
					startActivity(intent6);
					break;
				case 7:
					Uri uri7 = Uri.parse("http://food.39.net/a/130805/4229746.html");
					Intent intent7 = new Intent(Intent.ACTION_VIEW,uri7);
					startActivity(intent7);
					break;
				default:
					break;
				}
				
			}
        	
		});
	}
}
