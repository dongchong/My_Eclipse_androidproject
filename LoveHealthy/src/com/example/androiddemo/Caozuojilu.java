package com.example.androiddemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
public class Caozuojilu extends Activity{
    MyDatabaseHelper dbHelper;
    ImageView shuaxin;
    ListView listview;
    ImageView zhexiantu;
    List<Map<String, Object>> listItemsList;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caozuojilu);
        shuaxin = (ImageView)findViewById(R.id.shuaxin);
        dbHelper = new MyDatabaseHelper(this,"bmi_data", 1);
        listview = (ListView)findViewById(R.id.listView1);
        zhexiantu = (ImageView)findViewById(R.id.zhexiantu);
        listItemsList=new ArrayList<Map<String,Object>>();
        shuaxin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from data where height", null);
				while(cursor.moveToNext()){
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("id", cursor.getString(0));
					map.put("height", cursor.getString(1));
					map.put("weight", cursor.getString(2));
					listItemsList.add(map);
				}
				SimpleAdapter adapter=new SimpleAdapter(Caozuojilu.this, listItemsList,R.layout.activity_listview ,
		        		new String[]{"id","height","weight"}, 
		        		new int[]{R.id.idview,R.id.heightview,R.id.weightview});
				listview.setAdapter(adapter);
			}
		});
        zhexiantu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(Caozuojilu.this, Zhexiantu.class);
				startActivity(intent);
			}
		});
    }
    @Override
	public void onDestroy(){
    	super.onDestroy();
    	if (dbHelper != null) {
			dbHelper.close();
		}
    }
}