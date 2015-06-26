package com.example.androiddemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Tixing extends Activity{
	MediaPlayer alarm;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		alarm = MediaPlayer.create(this, R.raw.back);
		alarm.setLooping(true);
		alarm.start();
		new AlertDialog.Builder(Tixing.this).setTitle("健康闹钟").setMessage("闹钟响了，来看健康攻略吧。").setPositiveButton("确定", 
				new OnClickListener(){
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根
						alarm.stop();
						Tixing.this.finish();
					}
			
		}).show();
	}
}
