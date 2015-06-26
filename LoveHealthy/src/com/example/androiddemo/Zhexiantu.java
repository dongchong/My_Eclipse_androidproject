package com.example.androiddemo;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
public class Zhexiantu extends Activity{
	ArrayList<Integer> list1,list2,list3;
	MyDatabaseHelper dbHelper;
	GraphViewData[] graph,graph1;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhexiantu);
		dbHelper = new MyDatabaseHelper(this,"bmi_data", 1);
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from data where _id", null);
		list1 = new ArrayList<Integer>();
		list2 = new ArrayList<Integer>();
		list3 = new ArrayList<Integer>();
		while(cursor.moveToNext()){
			list1.add(Integer.parseInt(cursor.getString(0)));
			list2.add(Integer.parseInt(cursor.getString(1)));
			list3.add(Integer.parseInt(cursor.getString(2)));
		}
		graph = new GraphViewData[list1.size()];
		for (int i = 0; i < list1.size(); i++) {
			graph[i] = new GraphViewData((list1.get(i)).intValue(),(list2.get(i)).intValue());
			
		}
		GraphViewSeries example = new GraphViewSeries(graph);
		GraphView graphView = new LineGraphView(this,"身高变化图");
		graphView.addSeries(example);
		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		layout.addView(graphView);
		graph1 = new GraphViewData[list1.size()];
		for (int i = 0; i < list1.size(); i++) {
			graph1[i] = new GraphViewData((list1.get(i)).intValue(),(list3.get(i)).intValue());
			
		}
		GraphViewSeries example1 = new GraphViewSeries(graph1);
		GraphView graphView1 = new LineGraphView(this,"体重变化图");
		graphView1.addSeries(example1);
		LinearLayout layout1 = (LinearLayout) findViewById(R.id.graph2);
		layout1.addView(graphView1);
	}
}
