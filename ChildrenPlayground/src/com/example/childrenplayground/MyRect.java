package com.example.childrenplayground;

import android.graphics.Canvas;
import android.graphics.Paint;

public class MyRect {
	/**
	 * 因为积木界面是有四周的界限的，这里是绘制最上方、最下方、左边、右边界的矩形
	 * Canvas.drawRect()方法
	 * */
	private float x,y,w,h,angle;
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
	public MyRect(float x,float y,float w,float h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	//矩形图形的绘制函数
	public void drawRect(Canvas canvas,Paint paint){
		canvas.save();
		canvas.rotate(angle,x+w/2,y+h/2);
		canvas.drawRect(x,y,x+w,y+h, paint);
		canvas.restore();
	}
}
