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

public class Chunji extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chunji);
		ListView listView = (ListView)findViewById(R.id.listView1);
		//����һ������
		String[] arr ={"������������ ���������" , "������Ѽ������Ѫ������" , "�»Ƴ��ⲹ��Ч����","�ѹ�Ӣ���Ƚ�θ�ⴺ��","�����Դ���Ԥ����ð","�����㴻���ʳԷ���","�������㴻ͷ���Ĺ�������","�����ϻ����������"};
		//�������װArrayAdapter
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
			this , android.R.layout.simple_list_item_1 , arr);
		//ΪListView����Adapter
		listView.setAdapter(arrayAdapter);	
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO �Զ����ɵķ������
				switch (arg2) {
				case 0:
					Uri uri = Uri.parse("http://food.39.net/a/140430/4378266.html");
					Intent intent = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(intent);
					break;
				case 1:
					Uri uri1 = Uri.parse("http://food.39.net/a/140426/4378875.html");
					Intent intent1 = new Intent(Intent.ACTION_VIEW,uri1);
					startActivity(intent1);
					break;
				case 2:
					Uri uri2 = Uri.parse("http://food.39.net/a/140426/4378857.html");
					Intent intent2 = new Intent(Intent.ACTION_VIEW,uri2);
					startActivity(intent2);
					break;
				case 3:
					Uri uri3 = Uri.parse("http://food.39.net/a/140425/4378756.html");
					Intent intent3 = new Intent(Intent.ACTION_VIEW,uri3);
					startActivity(intent3);
					break;
				case 4:
					Uri uri4 = Uri.parse("http://food.39.net/a/140424/4378093.html");
					Intent intent4 = new Intent(Intent.ACTION_VIEW,uri4);
					startActivity(intent4);
					break;
				case 5:
					Uri uri5 = Uri.parse("http://food.39.net/a/140424/4377903.html");
					Intent intent5 = new Intent(Intent.ACTION_VIEW,uri5);
					startActivity(intent5);
					break;
				case 6:
					Uri uri6 = Uri.parse("http://food.39.net/a/140423/4377309.html");
					Intent intent6 = new Intent(Intent.ACTION_VIEW,uri6);
					startActivity(intent6);
					break;
				case 7:
					Uri uri7 = Uri.parse("http://food.39.net/a/140421/4375339.html");
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
