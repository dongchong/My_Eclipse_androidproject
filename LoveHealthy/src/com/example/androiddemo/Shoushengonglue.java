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

public class Shoushengonglue extends Activity{
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
		String fangfa = bundle.getString("NUM");
		MySurfaceView msf = new MySurfaceView(this,fangfa);
		setContentView(msf);
	}
	public class MySurfaceView extends SurfaceView implements Callback{
		private String fangfa;
		public MySurfaceView(Context context,String fangfa1) {
			super(context);
			// TODO 自动生成的构造函数存根
			sfh = this.getHolder();
			fangfa = fangfa1;
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
			if (fangfa.equals("黄瓜鸡蛋法")) {
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.huangguojidan);
			}else if(fangfa.equals("过午不食法")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.guowubushi);
			}else if(fangfa.equals("不吃正餐法")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.buchizhengcan);
			}else if(fangfa.equals("苹果减肥法")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.pingguojianfei);
			}else if(fangfa.equals("荷叶减肥法")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.heyejiefei);
			}else if(fangfa.equals("苦瓜减肥法")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.guguojianfei);
			}else if(fangfa.equals("喝水减肥法")){
				bmi = BitmapFactory.decodeResource(getResources(), R.drawable.heshuijianfei);
			}
			myDraw();
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder arg0) {
			// TODO 自动生成的方法存根
			
		}
		
	}
}
