package com.example.childrenplayground;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View{
	/**
	 * 美术模块中画图的界面
	 */
	float preX,preY,UP_X,UP_Y;
	Path path;
	public Paint paint = null;
	//VIEW_WIDTH和VIEW_HEIGHT分别为画图区域的大小
	final int VIEW_WIDTH = 1200;
	final int VIEW_HEIGHT = 1920;
	//定义一个内存中图片的缓冲区，该图片作为缓冲区
	Bitmap cacheBitmap = null;
	//定义cacheBitmap上的Canvas对象
	Canvas cacheCanvas = null;
	static String ShapeInfo = "曲线";
	public DrawView(Context context,AttributeSet set){
		super(context,set);
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH,VIEW_HEIGHT,Config.ARGB_8888);
		cacheCanvas = new Canvas();
		path = new Path();
		//设置cacheCanvas将会控制到内存中的cacheBitmap上
		cacheCanvas.setBitmap(cacheBitmap);
		//设置画笔颜色
		paint = new Paint();
		paint.setColor(Color.BLACK);
		//设置画笔风格
		paint.setStyle(Paint.Style.STROKE);
		//设置笔画的粗细
		paint.setStrokeWidth(10);
		//反锯齿
		paint.setAntiAlias(true);
		paint.setDither(true);
	}
	public boolean onTouchEvent(MotionEvent event){
		//鼠标点击的起始位置
		float x = event.getX();
		float y = event.getY();
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			path.moveTo(x, y);
			preX = x;
			preY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			path.quadTo(preX,preY,x,y);
			preX = x;
			preY = y;
			break;
		case MotionEvent.ACTION_UP:
			UP_X = x;
			UP_Y = y;
			if(ShapeInfo.equals("直线")){
				cacheCanvas.drawLine(preX, preY, UP_X, UP_Y, paint);
			}else if(ShapeInfo.equals("空心矩形")){
				
			}else if(ShapeInfo.equals("空心圆形")){
				
			}else if(ShapeInfo.equals("实心矩形")){
				
			}else if(ShapeInfo.equals("实心圆形")){
				
			}else if(ShapeInfo.equals("橡皮擦")){
				
			}else{
				cacheCanvas.drawPath(path,paint);
			}
			
			path.reset();
			break;
		}
		invalidate();
		return true;
	}
	@SuppressLint("DrawAllocation")
	public void onDraw(Canvas canvas){
		Paint bmpPaint = new Paint();
		//将cacheBitmap绘制到View上
		canvas.drawBitmap(cacheBitmap, 0,0, bmpPaint);
		if(ShapeInfo.equals("直线")){
			canvas.drawLine(preX, preY, UP_X, UP_Y, paint);
		}else if(ShapeInfo.equals("空心矩形")){
			
		}else if(ShapeInfo.equals("空心圆形")){
			
		}else if(ShapeInfo.equals("实心矩形")){
			
		}else if(ShapeInfo.equals("实心圆形")){
			
		}else if(ShapeInfo.equals("橡皮擦")){
			
		}else{
			canvas.drawPath(path,paint);
		}
		
	}
}
