package com.example.childrenplayground;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Art_Help extends Activity implements OnGestureListener{
	/**
	 * ���ֻ��һ��art�İ������棬���ǵ�����Ŵ󾵡�����ʾ�Ľ��ܽ���
	 */
	private ViewFlipper viewFlipper;
	private GestureDetector detector;
	private Animation[] animations = new Animation[4];
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.art_help);
		viewFlipper = (ViewFlipper)findViewById(R.id.art_help_viewflipper);
		detector = new GestureDetector(this,this);
		viewFlipper.addView(addImageView(R.drawable.palette_bangzhu_01));
		viewFlipper.addView(addImageView(R.drawable.palette_bangzhu_02));
		viewFlipper.addView(addImageView(R.drawable.palette_bangzhu_03));
		animations[0] = AnimationUtils.loadAnimation(this, R.anim.left_in);
        animations[1] = AnimationUtils.loadAnimation(this, R.anim.left_out);
        animations[2] = AnimationUtils.loadAnimation(this, R.anim.right_in);
        animations[3] = AnimationUtils.loadAnimation(this, R.anim.right_out);
        detector.setIsLongpressEnabled(true);
	}
	private View addImageView(int i) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(this);
		imageView.setImageResource(i);
		//setScaleType()�������ؼ���ͼ��Ӧ����ε�����С���ƶ���ƥ�����ͼƬ��Ĵ�С��
		//imageView.setScaleType(ImageView.ScaleType.CENTER);
		return imageView;
	}
	public boolean onTouchEvent(MotionEvent event){
		//����Activity�ϵĴ����¼�����GestureDetector����
		return detector.onTouchEvent(event);
	}
	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		if(velocityX>0){
			viewFlipper.setInAnimation(animations[2]);
			viewFlipper.setOutAnimation(animations[3]);
			viewFlipper.showPrevious();
			return true;
		}else if(velocityX<0){
			viewFlipper.setInAnimation(animations[0]);
			viewFlipper.setOutAnimation(animations[1]);
			viewFlipper.showNext();
			return true;
		}
		return false;
	}
	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
