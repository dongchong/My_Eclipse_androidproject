package com.example.childrenplayground;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Animal extends Activity implements OnGestureListener{
	/**
	 * 这是Animal的类
	 * 实现的是动物中的功能
	 * 小提示：在这个类对应的animal.xml中的ViewFlipper中添加了不同的RelativeLayout布局，每个布局中都有不同的ImageView组件。
	 * 所以此处不再需要给ViewFlipper添加View（不用在写addView（View v）的方法），可以直接实现需要的功能。
	 * */
	private ViewFlipper animal_show;
	private ImageView daxiang,laohu,shizi,houzi,xiongmao,ma,yang,ji,niu,wuya,mao,gou,laoshu;
	GestureDetector detector;
	RelativeLayout animal_caodi_01;
	private Animation[] animations = new Animation[4];
	private View MenuView = null;
	int[] mViewPos = new int[2];
	PopupWindow pop = null;
	ImageView imageView;
	TextView textView;
	//媒体播放器的类可用于控制音频/视频文件和流的播放。有关如何使用此类中的方法的一个例子可以发现，在播放视频。
	MediaPlayer mediaPlayer;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.animal);
        detector = new GestureDetector(this,this);
        animal_show = (ViewFlipper)findViewById(R.id.animal_show);
        daxiang = (ImageView)findViewById(R.id.daxiang);
        laohu = (ImageView)findViewById(R.id.laohu);
        shizi = (ImageView)findViewById(R.id.shizi);
        houzi = (ImageView)findViewById(R.id.houzi);
        xiongmao = (ImageView)findViewById(R.id.xiongmao);
        ma = (ImageView)findViewById(R.id.ma);
        yang = (ImageView)findViewById(R.id.yang);
        ji = (ImageView)findViewById(R.id.ji);
        niu = (ImageView)findViewById(R.id.niu);
        wuya = (ImageView)findViewById(R.id.wuya);
        mao = (ImageView)findViewById(R.id.mao);
        gou = (ImageView)findViewById(R.id.gou);
        laoshu = (ImageView)findViewById(R.id.laoshu);
        animal_caodi_01 = (RelativeLayout)findViewById(R.id.animal_caodi_1);
        animations[0] = AnimationUtils.loadAnimation(this, R.anim.left_in);
        animations[1] = AnimationUtils.loadAnimation(this, R.anim.left_out);
        animations[2] = AnimationUtils.loadAnimation(this, R.anim.right_in);
        animations[3] = AnimationUtils.loadAnimation(this, R.anim.right_out);
        //MenuView 为一个View，getLayoutInflater().inflate(int resourse,ViewGroup viewGroup);
        //android还允许我们在对话框中显示指定的xml文件，从而实现自定义对话框的效果。这个是显示点击大象图片，出现大象的介绍（图片和文字）
        MenuView = getLayoutInflater().inflate(R.layout.animal_show_info,null);
        imageView = (ImageView)MenuView.findViewById(R.id.animal_View);
		textView = (TextView)MenuView.findViewById(R.id.animal_text);
        daxiang.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				//问题：每次加View后如何去除？点击别的地方这个View是要消失的效果的？？？
				//所以在这里我们只有将MenuView当成PopupWindow来处理。。。
				imageView.setImageResource(R.drawable.zoo_animalpic_daxiang_02);
				textView.setText("大象 elephant");
				//这里不用animal_caodi_01.addView()，如果用的话是直接显示，不能消失，所以只能把图片介绍设置为PopupWindow
				//animal_caodi_01.addView(MenuView);
				//setPadding()主要是设置MenuView的位置，mViewPos显示的是大象图片的位置信息。
				//mViewPos[0]和mViewPos[1]分别表示父组件的x，y坐标
				//animal_caodi_01.setPadding(mViewPos[0], mViewPos[1]+10, 0, 0);
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_daxiang);
				mediaPlayer.start();
			}
		});
        laohu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_laohu_02);
				textView.setText("老虎 tiger");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_laohu);
				mediaPlayer.start();
			}
		});
        shizi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_shizi_02);
				textView.setText("狮子 lone");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_shizi);
				mediaPlayer.start();
			}
		});
        houzi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_houzi_02);
				textView.setText("猴子 monkey");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_houzi);
				mediaPlayer.start();
			}
		});
        xiongmao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_xiongmao_02);
				textView.setText("熊猫 panda");
				popMenu(MenuView,view);
			}
		});
        ma.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_ma_02);
				textView.setText("马 horse");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_ma);
				mediaPlayer.start();
			}
		});
        yang.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_yang_02);
				textView.setText("羊 sheep");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_yang);
				mediaPlayer.start();
			}
		});
        ji.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_ji_02);
				textView.setText("鸡 chicken");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_ji);
				mediaPlayer.start();
			}
		});
        niu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_niu_02);
				textView.setText("牛 cattle");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_niu);
				mediaPlayer.start();
			}
		});
        wuya.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_wuya_02);
				textView.setText("乌鸦 crow");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_wuya);
				mediaPlayer.start();
			}
		});
        mao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_mao_02);
				textView.setText("猫 cat");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_mao);
				mediaPlayer.start();
			}
		});
        gou.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_gou_02);
				textView.setText("狗 dog");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_gou);
				mediaPlayer.start();
			}
		});
        laoshu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_laoshu_02);
				textView.setText("老鼠 mouse");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_laohu);
				mediaPlayer.start();
			}
		});
	}
	//这个是设置PopupWindow的核心代码，很重要。。。
	public void popMenu(View menuview, View view) {
		if (pop == null) {
			pop = new PopupWindow(menuview, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
			//pop.setBackgroundDrawable(Drawable background);这个方法很重要，没有的话你点击图片出现图片介绍后将卡死，介绍图片不会消失
			//所以这里是必须要设置的，这里设置该背景透明
			pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			pop.setAnimationStyle(R.style.PopupAnimation);
			//setOutsideTouchable()是改PopupWindow是否可以点击
			pop.setOutsideTouchable(true);
			pop.showAsDropDown(view, Gravity.CENTER_HORIZONTAL, 0);
			pop.update();
		} else {
			if (pop.isShowing()) {
				//dismiss()是使其消失
				pop.dismiss();
				pop = null;
			} else {
				pop = null;
				pop = new PopupWindow(menuview, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
				//pop.setBackgroundDrawable(Drawable background);这个方法很重要，没有的话你点击图片出现图片介绍后将卡死，介绍图片不会消失
				//所以这里是必须要设置的，这里设置该背景透明
				pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				pop.setAnimationStyle(R.style.PopupAnimation);
				pop.setOutsideTouchable(false);
				pop.showAsDropDown(view, Gravity.CENTER_HORIZONTAL, 0);
				pop.update();
			}
		}
	}
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		//将该Activity上的触碰事件交给GestureDetector处理
		return detector.onTouchEvent(event);
	}
	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
			float VelocityY) {
		// TODO Auto-generated method stub
		if(velocityX>0){
			animal_show.setInAnimation(animations[2]);
			animal_show.setOutAnimation(animations[3]);
			animal_show.showPrevious();
			return true;
		}else if(velocityX<0){
			animal_show.setInAnimation(animations[0]);
			animal_show.setOutAnimation(animations[1]);
			animal_show.showNext();
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
