package com.example.childrenplayground;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class MyTile {
	/**
	 * ���������������ÿ����ľ���࣬ͨ��Canvas.drawBitmap()���������ƴ���ͼƬ�Ļ�ľ
	 * 
	 * */
	//��ľ�����ꡢ�����Ƕ�
	private float x,y,w,h,angle;
	//ͼƬ������Դ
	private Bitmap bmp;
	public MyTile(float x, float y, float w, float h, Bitmap bmp) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.bmp = bmp;
	}
	//ͨ��Paint��Canvas���л�ľ�Ļ���
	public void drawMyTile(Canvas canvas,Paint paint){
		canvas.save();//���浱ǰ�ľ��󵽶�ջ
		canvas.rotate(angle,x+w/2,y+h/2);//�ƶ��������ת�Ƕ�
		canvas.drawBitmap(bmp,x,y,paint);//���ƾ���
		canvas.restore();//�����ָ�Canvas֮ǰ�����״̬
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
