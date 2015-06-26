package com.example.childrenplayground;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class MyTile {
	/**
	 * 这个类是用来绘制每个积木的类，通过Canvas.drawBitmap()方法，绘制带有图片的积木
	 * 
	 * */
	//积木的坐标、宽高与角度
	private float x,y,w,h,angle;
	//图片数组资源
	private Bitmap bmp;
	public MyTile(float x, float y, float w, float h, Bitmap bmp) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.bmp = bmp;
	}
	//通过Paint和Canvas进行积木的绘制
	public void drawMyTile(Canvas canvas,Paint paint){
		canvas.save();//储存当前的矩阵到堆栈
		canvas.rotate(angle,x+w/2,y+h/2);//制定矩阵的旋转角度
		canvas.drawBitmap(bmp,x,y,paint);//绘制矩形
		canvas.restore();//用来恢复Canvas之前保存的状态
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getW() {
		return w;
	}
	public void setW(float w) {
		this.w = w;
	}
	public float getH() {
		return h;
	}
	public void setH(float h) {
		this.h = h;
	}
	public float getAngle() {
		return angle;
	}
	public void setAngle(float angle) {
		this.angle = angle;
	}
	public Bitmap getBmp() {
		return bmp;
	}
	public void setBmp(Bitmap bmp) {
		this.bmp = bmp;
	}
	
}
