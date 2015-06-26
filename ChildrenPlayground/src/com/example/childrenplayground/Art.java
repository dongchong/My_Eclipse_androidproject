package com.example.childrenplayground;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Art extends Activity{
	//home为以及菜单栏最中间的那个，star为二级菜单栏最中间那个
	private ImageView home,star,pencil,menu;
	private RelativeLayout level2,level3_01,level3_02,level3_03;
	private boolean isLevel2Show = true;
	private boolean isLevel3_02Show = true;
	private boolean isLevel3_01Show = false;
	private boolean isLevel3_03Show = false;
	private Button backcolor;
	private Button color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12;
	private TextView show;
	private DrawView dv;
	private ImageView a1_01,a2_01,a3_01,a4_01,a5_01,a6_01,a7_01;
	private ImageView b1_01,b2_01,b3_01,b4_01,b5_01,b6_01,b7_01;
	private ImageView c1_01,c2_01,c3_01,c4_01,c5_01,c6_01,c7_01;
	float phase;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.art);
        home = (ImageView)findViewById(R.id.home);
        star = (ImageView)findViewById(R.id.d2_01);
        pencil = (ImageView)findViewById(R.id.d1_01);
        menu = (ImageView)findViewById(R.id.d3_01);
        level2 = (RelativeLayout)findViewById(R.id.level2);
        level3_01 = (RelativeLayout)findViewById(R.id.level3_01);
        level3_02 = (RelativeLayout)findViewById(R.id.level3_02);
        level3_03 = (RelativeLayout)findViewById(R.id.level3_03);
        //View.INVISIBLE:控制该控件面板layout不可见，但是他依旧占用空间。
        //View.GONE:控制该控件面板消失。
        level3_01.setVisibility(View.INVISIBLE);
        level3_03.setVisibility(View.INVISIBLE);
        backcolor = (Button)findViewById(R.id.backcolor);
        color1 = (Button)findViewById(R.id.color1);
        color2 = (Button)findViewById(R.id.color2);
        color3 = (Button)findViewById(R.id.color3);
        color4 = (Button)findViewById(R.id.color4);
        color5 = (Button)findViewById(R.id.color5);
        color6 = (Button)findViewById(R.id.color6);
        color7 = (Button)findViewById(R.id.color7);
        color8 = (Button)findViewById(R.id.color8);
        color9 = (Button)findViewById(R.id.color9);
        color10 = (Button)findViewById(R.id.color10);
        color11 = (Button)findViewById(R.id.color11);
        color12 = (Button)findViewById(R.id.color12);
        show = (TextView)findViewById(R.id.show);
        dv = (DrawView)findViewById(R.id.draw);
        a1_01 = (ImageView)findViewById(R.id.a1_01);
        a2_01 = (ImageView)findViewById(R.id.a2_01);
        a3_01 = (ImageView)findViewById(R.id.a3_01);
        a4_01 = (ImageView)findViewById(R.id.a4_01);
        a5_01 = (ImageView)findViewById(R.id.a5_01);
        a6_01 = (ImageView)findViewById(R.id.a6_01);
        a7_01 = (ImageView)findViewById(R.id.a7_01);
        b1_01 = (ImageView)findViewById(R.id.b1_01);
        b2_01 = (ImageView)findViewById(R.id.b2_01);
        b3_01 = (ImageView)findViewById(R.id.b3_01);
        b4_01 = (ImageView)findViewById(R.id.b4_01);
        b5_01 = (ImageView)findViewById(R.id.b5_01);
        b6_01 = (ImageView)findViewById(R.id.b6_01);
        b7_01 = (ImageView)findViewById(R.id.b7_01);
        c1_01 = (ImageView)findViewById(R.id.c1_01);
        c2_01 = (ImageView)findViewById(R.id.c2_01);
        c3_01 = (ImageView)findViewById(R.id.c3_01);
        c4_01 = (ImageView)findViewById(R.id.c4_01);
        c5_01 = (ImageView)findViewById(R.id.c5_01);
        c6_01 = (ImageView)findViewById(R.id.c6_01);
        c7_01 = (ImageView)findViewById(R.id.c7_01);
        a1_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Art.this,Art_Help.class));
			}
		});
        a2_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dv.paint.setMaskFilter(null);
				dv.paint.setStyle(Paint.Style.FILL);
				dv.paint.setDither(false);
				dv.paint.setPathEffect(null);
			}
		});
        a3_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//new 一个BlurMaskFilter的对象，实现的是模糊效果
				//new BlurMaskFilter(float radius, BlurMaskFilter.Blur style):创建遮罩滤镜模糊。
				//radius是半径的大小
				dv.paint.setMaskFilter(new BlurMaskFilter(5,BlurMaskFilter.Blur.NORMAL));
				dv.paint.setStyle(Paint.Style.FILL);
				dv.paint.setPathEffect(null);
			}
		});
        a4_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//空心的直线还没有实现出来！！！
				dv.paint.setMaskFilter(null);
				dv.paint.setStyle(Paint.Style.STROKE);
				dv.paint.setColor(Color.BLACK);
				dv.paint.setAntiAlias(false);
			}
		});
       
        a5_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dv.paint.setShadowLayer(5, 3, 3, Color.BLACK);
				dv.paint.setPathEffect(null);
			}
		});
        a6_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dv.paint.setDither(true);
				dv.paint.setPathEffect(null);
			}
		});
        a7_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dv.paint.setPathEffect(new DashPathEffect(new float[]{20,10,5,10},phase));
			}
		});
        b1_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DrawView.ShapeInfo = "直线";
			}
		});
        b2_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Art.this,Art_Help.class));
				//DrawView.ShapeInfo = "直线";
			}
		});
        b3_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DrawView.ShapeInfo = "空心矩形";
			}
		});
        b4_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DrawView.ShapeInfo = "空心圆形";
			}
		});
        b5_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DrawView.ShapeInfo = "实心矩形";
			}
		});
        b6_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DrawView.ShapeInfo = "实心圆形";
			}
		});
        b7_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DrawView.ShapeInfo = "橡皮擦";
			}
		});
        color1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color1.getBackground());
				dv.paint.setColor(0xffbbaacc);
			}
		});
        color2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color2.getBackground());
				dv.paint.setColor(0xffaabbcc);
			}
		});
        color3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color3.getBackground());
				dv.paint.setColor(0xff0000ff);
			}
		});
        color4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color4.getBackground());
				dv.paint.setColor(0xff00ffaa);
			}
		});
        color5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color5.getBackground());
				dv.paint.setColor(0xff00ff00);
			}
		});
        color6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color6.getBackground());
				dv.paint.setColor(0xff00ffff);
			}
		});
        color7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color7.getBackground());
				dv.paint.setColor(0xffff0000);
			}
		});
        color8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color8.getBackground());
				dv.paint.setColor(0xffff00ff);
			}
		});
        color9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color9.getBackground());
				dv.paint.setColor(0xffffff00);
			}
		});
        color10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color10.getBackground());
				dv.paint.setColor(0xfff0f00f);
			}
		});
        color11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color11.getBackground());
				dv.paint.setColor(0xffff00ab);
			}
		});
        color12.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backcolor.setBackground(color12.getBackground());
				dv.paint.setColor(0xffad0f0a);
			}
		});
        star.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (isLevel3_02Show) {
					//如果菜单3显示，那么将菜单3隐藏
					MyAnimation.startAnimationOUT(level3_02,500,0);
				}else{
					//如果菜单3隐藏，那么将菜单3显示出来
					if(isLevel3_01Show){
						MyAnimation.startAnimationOUT(level3_01, 500, 0);
						MyAnimation.startAnimationIN(level3_02,500);
						isLevel3_01Show = !isLevel3_01Show;
						
					}else if(isLevel3_03Show){
						MyAnimation.startAnimationOUT(level3_03, 500, 0);
						MyAnimation.startAnimationIN(level3_02,500);
						isLevel3_03Show = !isLevel3_03Show;
					}else{
						MyAnimation.startAnimationIN(level3_02,500);
					}
				}
				isLevel3_02Show = !isLevel3_02Show;
			}
		});
        pencil.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (isLevel3_01Show) {
					MyAnimation.startAnimationOUT(level3_01, 500, 0);
				}else{
					if(isLevel3_02Show){
						MyAnimation.startAnimationOUT(level3_02, 500, 0);
						MyAnimation.startAnimationIN(level3_01, 500);
						isLevel3_02Show = !isLevel3_02Show;
					}else if(isLevel3_03Show){
						MyAnimation.startAnimationOUT(level3_03, 500, 0);
						MyAnimation.startAnimationIN(level3_01, 500);
						isLevel3_03Show = !isLevel3_03Show;
					}else{
						MyAnimation.startAnimationIN(level3_01, 500);
					}
				}
				isLevel3_01Show = !isLevel3_01Show;
			}
		});
        menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (isLevel3_03Show) {
					MyAnimation.startAnimationOUT(level3_03, 500, 0);
				}else{
					if(isLevel3_01Show){
						MyAnimation.startAnimationOUT(level3_01, 500, 0);
						MyAnimation.startAnimationIN(level3_03, 500);
						isLevel3_01Show = !isLevel3_03Show;
					}else if(isLevel3_02Show){
						MyAnimation.startAnimationOUT(level3_02, 500, 0);
						MyAnimation.startAnimationIN(level3_03, 500);
						isLevel3_02Show = !isLevel3_02Show;
					}else{
						MyAnimation.startAnimationIN(level3_03, 500);
					}
				}
				isLevel3_03Show = !isLevel3_03Show;
			}
		});
        home.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!isLevel2Show){
					//显示2级菜单
					MyAnimation.startAnimationIN(level2,500);
				}else{
					if (isLevel3_02Show) {
						//隐藏3级菜单
						MyAnimation.startAnimationOUT(level3_02,500,0);
						//隐藏2级菜单
						MyAnimation.startAnimationOUT(level2,1000,0);
						isLevel3_02Show = !isLevel3_02Show;
					}else if(isLevel3_01Show){
						MyAnimation.startAnimationOUT(level3_01, 500, 0);
						MyAnimation.startAnimationOUT(level2, 1000, 0);
						isLevel3_01Show = !isLevel3_01Show;
					}else if(isLevel3_03Show){
						MyAnimation.startAnimationOUT(level3_03, 500, 0);
						MyAnimation.startAnimationOUT(level2, 1000, 0);
						isLevel3_03Show = !isLevel3_03Show;
					}else{
						//隐藏2级菜单
						MyAnimation.startAnimationOUT(level2,500,0);
					}
				}
				
				isLevel2Show = !isLevel2Show;
			}
		});
	}
}
