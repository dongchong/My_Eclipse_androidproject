package com.example.childrenplayground;

import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Callback,Runnable{
	private Thread th;
	private SurfaceHolder sfh;
	private Canvas canvas;
	private Paint paint;
	private boolean flag;
	public Context context;
	//�����������
	private float RATE = 30;//��Ļ����ʵ����ı�����30px:1m
	private World world;//����һ�������������
	private float stepTime = 1f/60f;//��������ģ���Ƶ��
	private int iteraTions = 10;//����ֵԽ��ģ��Խ��ȷ��������Խ��
	private Bitmap bmpBg;//����ͼ
	private Bitmap[] bmpTile;//ÿ��Ӣ�ĵ��ʵ�ͼƬ
	//�������ھ���ؽ��Ϲ̶���Body��������
	private int bodyWallX,bodyWallY,bodyWallW,bodyWallH;
	private Body body;//��ÿ��Ӣ�ﵥ�ʰ󶨵�ש��
	private int[] bitmap = {R.drawable.letter1,R.drawable.letter2,R.drawable.letter3,R.drawable.letter4,
			R.drawable.letter5,R.drawable.letter6,R.drawable.letter7,R.drawable.letter8,
			R.drawable.letter9,R.drawable.letter10,R.drawable.letter11,R.drawable.letter12,
			R.drawable.letter13,R.drawable.letter14,R.drawable.letter15,R.drawable.letter16,
			R.drawable.letter17,R.drawable.letter18,R.drawable.letter19,R.drawable.letter20,
			R.drawable.letter21,R.drawable.letter22,R.drawable.letter23,R.drawable.letter24,
			R.drawable.letter25,R.drawable.letter26};
	public MySurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		bmpTile = new Bitmap[26];
		this.setKeepScreenOn(true);//����Ļһֱ���ֿ���״̬
		sfh = this.getHolder();//����SurfaceHolder�ṩ���ʺͿ���ƽ����ͼ�Ļ�����
		sfh.addCallback(this);
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		setFocusable(true);//���ÿռ�Ϊ�ɵ��״̬
		//���һ�������ģ��״̬
		AABB aabb = new AABB();//ʵ������������ķ�Χ����
		aabb.lowerBound = new Vec2(-100,-100);//���������������Ͻǵ�����
		aabb.upperBound = new Vec2(100,100);//���������������½ǵ�����
		Vec2 gravity = new Vec2(0,10);//ʵ���������������������Ķ���
		world = new World(aabb,gravity,true);//ʵ������������Ķ���
		//ʵ����ÿ��Ӣ�ĵ��ʵ�ͼƬ
		for (int i = 0; i < bmpTile.length; i++) {
			bmpTile[i] = BitmapFactory.decodeResource(context.getResources(),bitmap[i]);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	//����view����Ϸ�ĳ�ʼ��
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		bodyWallW = 40;
		bodyWallH = 2;
		bodyWallX = getWidth()/2 - bodyWallW/2;
		bodyWallY = 1;
		//body = createMyTile(bodyWallX/2,)
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}

}
