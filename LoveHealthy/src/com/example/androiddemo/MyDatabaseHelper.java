package com.example.androiddemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//数据库的类
public class MyDatabaseHelper extends SQLiteOpenHelper{
	final String CREATE_TABLE_SQL = 
			"create table data(_id integer primary key autoincrement,height,weight)";
	public MyDatabaseHelper(Context context,String name,int version){
		super(context,name,null,version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		db.execSQL(CREATE_TABLE_SQL);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根
		System.out.println("--------onUpdate Called--------"+oldVersion +"--->"+newVersion);
	}
	
}
