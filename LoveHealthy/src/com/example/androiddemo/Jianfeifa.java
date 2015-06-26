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
		//����һ������
		String[] arr ={"1���ƹϼ�����" , "2�����粻ʳ��" , "3���������ͷ�","4��ƻ�����ʷ�","5����Ҷ���ʷ�","6����ϼ��ʷ�","7����ˮ���ʷ�"};
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
