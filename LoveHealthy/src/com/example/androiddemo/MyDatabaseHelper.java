package com.example.androiddemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//���ݿ����
public class MyDatabaseHelper extends SQLiteOpenHelper{
	final String CREATE_TABLE_SQL = 
			"create table data(_id integer primary key autoincrement,height,weight)";
	public MyDatabaseHelper(Context context,String name,int version){
		super(context,name,null,version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �Զ����ɵķ������
		db.execSQL(CREATE_TABLE_SQL);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
		// TODO �Զ����ɵķ������
		System.out.println("--------onUpdate Called--------"+oldVersion +"--->"+newVersion);
	}
	
}
