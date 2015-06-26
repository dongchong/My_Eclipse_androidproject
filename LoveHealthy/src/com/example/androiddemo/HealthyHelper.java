package com.example.androiddemo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
public class HealthyHelper extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthyhelper);
        ListView listView = (ListView)findViewById(R.id.list3);
		String[] arr ={"1����ð" , "2������" , "3������","4������","5����������","6������Ѿ�","7��������ͷʹ","8�������Ը�ð","9������","10��Ƥ��ˤ��"};
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
			this , android.R.layout.simple_list_item_1 , arr);
		listView.setAdapter(arrayAdapter);	
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent();
				intent.setClass(HealthyHelper.this, HealthyHelper2.class);
				Bundle bundle = new Bundle();
				String texttheme = HealthyHelper.this.getResources().getStringArray(R.array.info)[arg2];
				bundle.putString("TEXT", texttheme);
				intent.putExtras(bundle);
				//Toast.makeText(HealthyHelper.this, texttheme,  Toast.LENGTH_SHORT).show();
				startActivity(intent);
			}
        	
		});
    }
}