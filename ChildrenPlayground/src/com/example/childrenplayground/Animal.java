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
	 * ����Animal����
	 * ʵ�ֵ��Ƕ����еĹ���
	 * С��ʾ����������Ӧ��animal.xml�е�ViewFlipper������˲�ͬ��RelativeLayout���֣�ÿ�������ж��в�ͬ��ImageView�����
	 * ���Դ˴�������Ҫ��ViewFlipper���View��������дaddView��View v���ķ�����������ֱ��ʵ����Ҫ�Ĺ��ܡ�
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
	//ý�岥������������ڿ�����Ƶ/��Ƶ�ļ������Ĳ��š��й����ʹ�ô����еķ�����һ�����ӿ��Է��֣��ڲ�����Ƶ��
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
        //MenuView Ϊһ��View��getLayoutInflater().inflate(int resourse,ViewGroup viewGroup);
        //android�����������ڶԻ�������ʾָ����xml�ļ����Ӷ�ʵ���Զ���Ի����Ч�����������ʾ�������ͼƬ�����ִ���Ľ��ܣ�ͼƬ�����֣�
        MenuView = getLayoutInflater().inflate(R.layout.animal_show_info,null);
        imageView = (ImageView)MenuView.findViewById(R.id.animal_View);
		textView = (TextView)MenuView.findViewById(R.id.animal_text);
        daxiang.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				//���⣺ÿ�μ�View�����ȥ���������ĵط����View��Ҫ��ʧ��Ч���ģ�����
				//��������������ֻ�н�MenuView����PopupWindow����������
				imageView.setImageResource(R.drawable.zoo_animalpic_daxiang_02);
				textView.setText("���� elephant");
				//���ﲻ��animal_caodi_01.addView()������õĻ���ֱ����ʾ��������ʧ������ֻ�ܰ�ͼƬ��������ΪPopupWindow
				//animal_caodi_01.addView(MenuView);
				//setPadding()��Ҫ������MenuView��λ�ã�mViewPos��ʾ���Ǵ���ͼƬ��λ����Ϣ��
				//mViewPos[0]��mViewPos[1]�ֱ��ʾ�������x��y����
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
				textView.setText("�ϻ� tiger");
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
				textView.setText("ʨ�� lone");
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
				textView.setText("���� monkey");
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
				textView.setText("��è panda");
				popMenu(MenuView,view);
			}
		});
        ma.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				pop.dismiss();
				imageView.setImageResource(R.drawable.zoo_animalpic_ma_02);
				textView.setText("�� horse");
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
				textView.setText("�� sheep");
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
				textView.setText("�� chicken");
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
				textView.setText("ţ cattle");
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
				textView.setText("��ѻ crow");
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
				textView.setText("è cat");
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
				textView.setText("�� dog");
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
				textView.setText("���� mouse");
				popMenu(MenuView,view);
				mediaPlayer=MediaPlayer.create(Animal.this, R.raw.zoo_animalraw_laohu);
				mediaPlayer.start();
			}
		});
	}
	//���������PopupWindow�ĺ��Ĵ��룬����Ҫ������
	public void popMenu(View menuview, View view) {
		if (pop == null) {
			pop = new PopupWindow(menuview, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
			//pop.setBackgroundDrawable(Drawable background);�����������Ҫ��û�еĻ�����ͼƬ����ͼƬ���ܺ󽫿���������ͼƬ������ʧ
			//���������Ǳ���Ҫ���õģ��������øñ���͸��
			pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			pop.setAnimationStyle(R.style.PopupAnimation);
			//setOutsideTouchable()�Ǹ�PopupWindow�Ƿ���Ե��
			pop.setOutsideTouchable(true);
			pop.showAsDropDown(view, Gravity.CENTER_HORIZONTAL, 0);
			pop.update();
		} else {
			if (pop.isShowing()) {
				//dismiss()��ʹ����ʧ
				pop.dismiss();
				pop = null;
			} else {
				pop = null;
				pop = new PopupWindow(menuview, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
				//pop.setBackgroundDrawable(Drawable background);�����������Ҫ��û�еĻ�����ͼƬ����ͼƬ���ܺ󽫿���������ͼƬ������ʧ
				//���������Ǳ���Ҫ���õģ��������øñ���͸��
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
