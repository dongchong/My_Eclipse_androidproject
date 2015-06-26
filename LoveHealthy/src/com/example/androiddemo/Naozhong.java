package com.example.androiddemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;
public class Naozhong extends Activity{
	private ImageView naozhong;
	private AlarmManager manager;
	private Button quxiao;
	Calendar currentTime = Calendar.getInstance();
	@Override
	public void onCreate(Bundle savedInstanedState){
		super.onCreate(savedInstanedState);
		setContentView(R.layout.naozhong);
		naozhong = (ImageView)findViewById(R.id.naozhong2);
		quxiao = (Button)findViewById(R.id.quxiao);
		manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		naozhong.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Calendar currentTime=Calendar.getInstance();
				new TimePickerDialog(Naozhong.this,0,new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker arg0, int arg1, int arg2) {
						// TODO 自动生成的方法存根
						Intent intent = new Intent(Naozhong.this,Tixing.class);
						PendingIntent pi = PendingIntent.getActivity(Naozhong.this, 0, intent, 0);
						Calendar c = Calendar.getInstance();
						c.setTimeInMillis(System.currentTimeMillis());
						c.set(Calendar.HOUR, arg1);
						c.set(Calendar.MINUTE,arg2);
						manager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
						Toast.makeText(Naozhong.this, "闹钟设置成功", 5000).show();
					}
				},currentTime.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),false).show();
			}
		});
		quxiao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(Naozhong.this,Tixing.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(Naozhong.this, 0, intent, 0);
				AlarmManager am;
				am = (AlarmManager)getSystemService(ALARM_SERVICE);
				am.cancel(pendingIntent);
				Toast.makeText(Naozhong.this, "闹钟已取消", 5000).show();
			}
		});
	}
}
