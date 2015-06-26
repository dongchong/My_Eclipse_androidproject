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
	 * ����ģ���л�ͼ�Ľ���
	 */
	float preX,preY,UP_X,UP_Y;
	Path path;
	public Paint paint = null;
	//VIEW_WIDTH��VIEW_HEIGHT�ֱ�Ϊ��ͼ����Ĵ�С
	final int VIEW_WIDTH = 1200;
	final int VIEW_HEIGHT = 1920;
	//����һ���ڴ���ͼƬ�Ļ���������ͼƬ��Ϊ������
	Bitmap cacheBitmap = null;
	//����cacheBitmap�ϵ�Canvas����
	Canvas cacheCanvas = null;
	static String ShapeInfo = "����";
	public DrawView(Context context,AttributeSet set){
		super(context,set);
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH,VIEW_HEIGHT,Config.ARGB_8888);
		cacheCanvas = new Canvas();
		path = new Path();
		//����cacheCanvas������Ƶ��ڴ��е�cacheBitmap��
		cacheCanvas.setBitmap(cacheBitmap);
		//���û�����ɫ
		paint = new Paint();
		paint.setColor(Color.BLACK);
		//���û��ʷ��
		paint.setStyle(Paint.Style.STROKE);
		//���ñʻ��Ĵ�ϸ
		paint.setStrokeWidth(10);
		//�����
		paint.setAntiAlias(true);
		paint.setDither(true);
	}
	public boolean onTouchEvent(MotionEvent event){
		//���������ʼλ��
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
			if(ShapeInfo.equals("ֱ��")){
				cacheCanvas.drawLine(preX, preY, UP_X, UP_Y, paint);
			}else if(ShapeInfo.equals("���ľ���")){
				
			}else if(ShapeInfo.equals("����Բ��")){
				
			}else if(ShapeInfo.equals("ʵ�ľ���")){
				
			}else if(ShapeInfo.equals("ʵ��Բ��")){
				
			}else if(ShapeInfo.equals("��Ƥ��")){
				
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
		//��cacheBitmap���Ƶ�View��
		canvas.drawBitmap(cacheBitmap, 0,0, bmpPaint);
		if(ShapeInfo.equals("ֱ��")){
			canvas.drawLine(preX, preY, UP_X, UP_Y, paint);
		}else if(ShapeInfo.equals("���ľ���")){
			
		}else if(ShapeInfo.equals("����Բ��")){
			
		}else if(ShapeInfo.equals("ʵ�ľ���")){
			
		}else if(ShapeInfo.equals("ʵ��Բ��")){
			
		}else if(ShapeInfo.equals("��Ƥ��")){
			
		}else{
			canvas.drawPath(path,paint);
		}
		
	}
}
