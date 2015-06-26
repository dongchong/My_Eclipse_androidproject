package com.example.childrenplayground;

import android.app.Activity;
import android.os.Bundle;

public class English extends Activity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(new MySurfaceView(this));
	}
}
