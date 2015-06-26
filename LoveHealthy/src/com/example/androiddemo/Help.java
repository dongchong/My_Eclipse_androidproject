package com.example.androiddemo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
public class Help extends Activity{
	private String helpinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        ListView listView = (ListView)findViewById(R.id.list4);
		String[] arr ={"1��BMI" , "2������ƻ�" , "3���Եý���","4������С����","5����������","6���Ҹ�����"};
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
			this , android.R.layout.simple_list_item_1 , arr);
		listView.setAdapter(arrayAdapter);	
        listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent();
				intent.setClass(Help.this, HelpInfo.class);
				Bundle bundle = new Bundle();
				helpinfo = Help.this.getResources().getStringArray(R.array.help_info)[arg2];
				bundle.putString("NUM", helpinfo);
				intent.putExtras(bundle);
				Toast.makeText(Help.this, helpinfo,  Toast.LENGTH_SHORT).show();
				startActivity(intent);
			}
        	
		});
    }
}