package com.example.childrenplayground;

import android.graphics.Canvas;
import android.graphics.Paint;

public class MyRect {
	/**
	 * ��Ϊ��ľ�����������ܵĽ��޵ģ������ǻ������Ϸ������·�����ߡ��ұ߽�ľ���
	 * Canvas.drawRect()����
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
	//����ͼ�εĻ��ƺ���
	public void drawRect(Canvas canvas,Paint paint){
		canvas.save();
		canvas.rotate(angle,x+w/2,y+h/2);
		canvas.drawRect(x,y,x+w,y+h, paint);
		canvas.restore();
	}
}
