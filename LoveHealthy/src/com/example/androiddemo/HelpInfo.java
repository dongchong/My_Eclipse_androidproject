package com.example.androiddemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

public class HelpInfo extends Activity{
	private Bitmap bmi;
	private Canvas canvas;
	private SurfaceHolder sfh;
	private Paint paint;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//全屏显示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Bundle bundle = this.getIntent().getExtras();
		String help_info = bundle.getString("NUM");
		MySurfaceView msf = new MySurfaceView(this,help_info);
		setContentView(msf);
	}
	public class MySurfaceView extends SurfaceView implements Callback{
		private String help_info;
		public MySurfaceView(Context context,String fangfa1) {
			super(context);
			// TODO 自动生成的构造函数存根
			sfh = this.getHolder();
			help_info = fangfa1;
			sfh.addCallback(this);
			paint = new Paint();
			paint.setColor(Color.WHITE);
			paint.setAntiAlias(true);
			setFocusable(true);
		}

		private void myDraw() {
			// TODO 自动生成的方法存根
			try {
				canvas = sfh.lockCanvas();
				if(canvas!=null){
					canvas.drawColor(Color.WHITE);
					canvas.drawBitmap(bmi,0,0,new Paint());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				if (canvas!=null) {
					sfh.unlockCanvasAndPost(canvas);
				}
			}
		}

		@Override
		public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2,
				int arg3) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void surfaceCreated(SurfaceHolder arg0) {
			// TODO 自动生成的方法存根
			if (help_info.equals("BMI")) {
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.bmiinfo);
			}else if(help_info.equals("瘦身计划")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.shousheninfo);
			}else if(help_info.equals("吃得健康")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.chideinfo);
			}else if(help_info.equals("健康小闹钟")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.naozhonginfo);
			}else if(help_info.equals("健康助手")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.zhushouinfo);
			}else if(help_info.equals("幸福生活")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.shenghuoinfo);
			}
			myDraw();
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder arg0) {
			// TODO 自动生成的方法存根
			
		}
		
	}
}
