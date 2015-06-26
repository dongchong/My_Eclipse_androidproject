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
	//添加物理世界
	private float RATE = 30;//屏幕与现实世界的比例：30px:1m
	private World world;//声明一个物理世界对象
	private float stepTime = 1f/60f;//物理世界模拟的频率
	private int iteraTions = 10;//迭代值越大模拟越精确，但性能越低
	private Bitmap bmpBg;//背景图
	private Bitmap[] bmpTile;//每个英文单词的图片
	//声明绑定在距离关节上固定的Body坐标与宽高
	private int bodyWallX,bodyWallY,bodyWallW,bodyWallH;
	private Body body;//与每个英语单词绑定的砖块
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
		this.setKeepScreenOn(true);//将屏幕一直保持开启状态
		sfh = this.getHolder();//返回SurfaceHolder提供访问和控制平面视图的基础面
		sfh.addCallback(this);
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		setFocusable(true);//设置空间为可点击状态
		//添加一个物理的模拟状态
		AABB aabb = new AABB();//实例化物理世界的范围对象
		aabb.lowerBound = new Vec2(-100,-100);//设置物理世界左上角的坐标
		aabb.upperBound = new Vec2(100,100);//设置物理世界右下角的坐标
		Vec2 gravity = new Vec2(0,10);//实例化物理世界重力向量的对象
		world = new World(aabb,gravity,true);//实例化物理世界的对象
		//实例化每个英文单词的图片
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

	//创建view与游戏的初始化
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
