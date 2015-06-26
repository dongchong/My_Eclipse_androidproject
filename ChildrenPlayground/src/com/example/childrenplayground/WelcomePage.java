package com.example.childrenplayground;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomePage extends Activity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomepage);
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				Intent intent = new Intent(WelcomePage.this,MainActivity.class);
				startActivity(intent);
				WelcomePage.this.finish();
			}
		};
		timer.schedule(task, 2000);
	}
}
