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
		new AlertDialog.Builder(Tixing.this).setTitle("��������").setMessage("�������ˣ������������԰ɡ�").setPositiveButton("ȷ��", 
				new OnClickListener(){
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO �Զ����ɵķ������
						alarm.stop();
						Tixing.this.finish();
					}
			
		}).show();
	}
}
