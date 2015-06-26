package com.example.childrenplayground;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;
public class MainActivity extends Activity implements OnGestureListener{
	MediaPlayer mMediaPlayer;
	SoundPool soundPool;
	ImageView imageView;
	//ViewFlipper �����������ͼ֮��ļ򵥲鿴��������������ӵ�����һ��ֻ��ʾһ�����ӡ� �����Ҫ�����Զ���֮���Զ��л���ÿ�����ӡ�
	ViewFlipper flipper;
	//Animation ���󶯻�������Ӧ�õ���ͼ������������󡣿�������������������������ļ���
	Animation[] animations = new Animation[4];
	//����һ������ʶ��GestureDetector����һ�����Ƽ����
	GestureDetector detector;
	//��һ��image�������������е�ͼƬ
	int[] image = {R.drawable.child_function_01,R.drawable.child_function_02,R.drawable.child_function_03,R.drawable.child_function_04,
			R.drawable.child_function_05,R.drawable.child_function_06,R.drawable.child_function_07,R.drawable.child_function_08,R.drawable.child_function_09,
			R.drawable.child_function_10};
	ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ʼ������
        initSounds();
        imageView = (ImageView)findViewById(R.id.imageView1);
        imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int[] arr = {R.raw.welcome_child_01,R.raw.welcome_child_02,R.raw.welcome_child_03,R.raw.welcome_child_04};
				int i = (int)(Math.random()*4);
				MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, arr[i]);
				mediaPlayer.start();
			}
		});
        detector = new GestureDetector(this,this);
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        for (int i = 0; i < 10; i++) {
			flipper.addView(addImageView(image[i]));
		}
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
		imageView.setScaleType(ImageView.ScaleType.CENTER);
		return imageView;
	}
	//��ʼ�������ķ���
    public void initSounds(){
    	mMediaPlayer = MediaPlayer.create(this, R.raw.butterfly);
    	mMediaPlayer.start();
    	mMediaPlayer.setLooping(true);
    }
    //����Activity�е�onStop�������ǵĹر�Ӧ��ʱ��������ֹͣ
    public void onStop(){
    	super.onStop();
    	mMediaPlayer.stop();
    }
    @Override
	public boolean onTouchEvent(MotionEvent event)
	{
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
		//���onFling�����У�velocityX�Ϲ��ں����ϵ��ٶȣ�����������velocityX>0,����������velocityX<0
		//velocityYΪ�������ϵ��ٶ�
		if(velocityX>0){
			flipper.setInAnimation(animations[2]);
			flipper.setOutAnimation(animations[3]);
			flipper.showPrevious();
			return true;
		}else if(velocityX<0){
			flipper.setInAnimation(animations[0]);
			flipper.setOutAnimation(animations[1]);
			flipper.showNext();
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
		if(flipper.getDisplayedChild()==0){
			flipper.getCurrentView().setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					startActivity(new Intent(MainActivity.this,Art.class));
				}
			});
		}else if(flipper.getDisplayedChild()==1){
			flipper.getCurrentView().setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					startActivity(new Intent(MainActivity.this,Animal.class));
				}
			});
		}else if(flipper.getDisplayedChild()==2){
			flipper.getCurrentView().setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					startActivity(new Intent(MainActivity.this,WaWa.class));
				}
			});
		}else if(flipper.getDisplayedChild()==3){
			flipper.getCurrentView().setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					startActivity(new Intent(MainActivity.this,English.class));
				}
			});
		}else if(flipper.getDisplayedChild()==4){
			flipper.getCurrentView().setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					startActivity(new Intent(MainActivity.this,Jimu.class));
				}
			});
		}else if(flipper.getDisplayedChild()==5){
			flipper.getCurrentView().setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					startActivity(new Intent(MainActivity.this,Sport.class));
				}
			});
		}
		return false;
	}
	
}
