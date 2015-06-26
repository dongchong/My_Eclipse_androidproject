package com.example.childrenplayground;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;

public class MyAnimation {
	//这个类是关联Art的类，主要是给一级二级三级菜单添加显示、隐藏动画
	public static void startAnimationIN(ViewGroup viewGroup,int duration){//显示菜单
		for (int i = 0; i < viewGroup.getChildCount(); i++) {
			viewGroup.getChildAt(i).setVisibility(View.VISIBLE);//显示子菜单
			viewGroup.getChildAt(i).setFocusable(true);//设置此视图可以接受焦点
			viewGroup.getChildAt(i).setClickable(true);//设置此视图可以点击
		}
		Animation animation;
		//RotateAnimation:动画控件对象的旋转。这个旋转发生国际X-Y平面。您可以指定要使用的点为中心旋转，(00)是左上角的点。如果未指定，则(00)是缺省旋转点。
		/** 
         * 旋转动画 
         * RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue) 
         * fromDegrees 开始旋转角度 
         * toDegrees 旋转到的角度 
         * pivotXType X轴 参照物 
         * pivotXValue x轴 旋转的参考点 
         * pivotYType Y轴 参照物 
         * pivotYValue Y轴 旋转的参考点 
         */
		//Animation.RELATIVE_TO_SELF:指定维度拥有浮动，应乘以正在进行动画处理的对象的高度或宽度。
		animation = new RotateAnimation(-180,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1.0f);
		animation.setFillAfter(true);//停留在动画结束的位置
		animation.setDuration(duration);//动画持续的时间
		viewGroup.startAnimation(animation);//开始动画
	}
	public static void startAnimationOUT(final ViewGroup viewGroup,int duration,int startOffset){//隐藏菜单
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
