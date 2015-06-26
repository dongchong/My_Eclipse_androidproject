package com.example.childrenplayground;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;

public class MyAnimation {
	//������ǹ���Art���࣬��Ҫ�Ǹ�һ�����������˵������ʾ�����ض���
	public static void startAnimationIN(ViewGroup viewGroup,int duration){//��ʾ�˵�
		for (int i = 0; i < viewGroup.getChildCount(); i++) {
			viewGroup.getChildAt(i).setVisibility(View.VISIBLE);//��ʾ�Ӳ˵�
			viewGroup.getChildAt(i).setFocusable(true);//���ô���ͼ���Խ��ܽ���
			viewGroup.getChildAt(i).setClickable(true);//���ô���ͼ���Ե��
		}
		Animation animation;
		//RotateAnimation:�����ؼ��������ת�������ת��������X-Yƽ�档������ָ��Ҫʹ�õĵ�Ϊ������ת��(00)�����Ͻǵĵ㡣���δָ������(00)��ȱʡ��ת�㡣
		/** 
         * ��ת���� 
         * RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue) 
         * fromDegrees ��ʼ��ת�Ƕ� 
         * toDegrees ��ת���ĽǶ� 
         * pivotXType X�� ������ 
         * pivotXValue x�� ��ת�Ĳο��� 
         * pivotYType Y�� ������ 
         * pivotYValue Y�� ��ת�Ĳο��� 
         */
		//Animation.RELATIVE_TO_SELF:ָ��ά��ӵ�и�����Ӧ�������ڽ��ж�������Ķ���ĸ߶Ȼ��ȡ�
		animation = new RotateAnimation(-180,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1.0f);
		animation.setFillAfter(true);//ͣ���ڶ���������λ��
		animation.setDuration(duration);//����������ʱ��
		viewGroup.startAnimation(animation);//��ʼ����
	}
	public static void startAnimationOUT(final ViewGroup viewGroup,int duration,int startOffset){//���ز˵�
		Animation animation;
		animation = new RotateAnimation(0,-180,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1.0f);
		animation.setFillAfter(true);
		animation.setDuration(duration);
		animation.setStartOffset(startOffset);
		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < viewGroup.getChildCount(); i++) {
					viewGroup.getChildAt(i).setVisibility(View.GONE);
					viewGroup.getChildAt(i).setFocusable(false);
					viewGroup.getChildAt(i).setClickable(false);
				}
			}
		});
		viewGroup.startAnimation(animation);
	}
}
