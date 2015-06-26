package com.example.childrenplayground;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
/**
 * 这个类似展示积木的一个类
 * 这个类注释比较少，每一行都类似于英语那部门，那里有详细的注释
 * */
public class JimuShow extends SurfaceView implements Callback,Runnable{
	private Thread th;
	private SurfaceHolder sfh;
	private Canvas canvas;
	private Paint paint;
	private boolean flag;
	public Context context;
	//添加一个物理世界
	private float RATE = 30;
	private World world;
	private float stepTime = 1f/60f;//物理世界模拟的频率
	private int iteraTions = 10;//迭代值，迭代值越大模拟越精确，但是效率越低
	//背景图
	private Bitmap[] bmpBg;
	private Bitmap bmpBackground;
	private Body[] bodyJimu;
	private int [] bmp = {R.drawable.box1,R.drawable.box2,R.drawable.box3,R.drawable.box3,
					R.drawable.box4,R.drawable.circle1,R.drawable.circle2,R.drawable.triangle1,
					R.drawable.triangle2};
	private boolean isDown;
	private int isDownCount = 0;
	public JimuShow(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//每个积木方块的九张图片组成的积木
		bmpBg = new Bitmap[9];
		bodyJimu = new Body[9];
		this.context = context;
		this.setKeepScreenOn(true);//保持屏幕开启状态
		sfh = this.getHolder();//SurfaceHolder相当于SurfaceView的一个监听器，通过this.getHolder()来监听SurfaceView
		sfh.addCallback(this);//为Surfaceholder添加一个SurfaceHolder.addCallback()的回调接口
		paint = new Paint();//设置一个画笔
		paint.setStyle(Style.STROKE);
		setFocusable(true);//设置控件可点击
		setFocusableInTouchMode(true);//触摸是否获得焦点
		//添加物理世界
		AABB aabb = new AABB();
		//物理世界的左上角坐标
		aabb.lowerBound = new Vec2(-100,-100);
		//物理世界的右下角坐标//Vec2表示一个二维坐标
		aabb.upperBound = new Vec2(100,100);
		Vec2 gravity = new Vec2(0,10);//设置物理世界重力向量的对象
		world = new World(aabb,gravity,true);
		//实例化每个积木对象
		for (int i = 0; i < bmpBg.length; i++) {
			bmpBg[i] = BitmapFactory.decodeResource(context.getResources(), bmp[i]);
		}
		//实例化背景图片
		bmpBackground = BitmapFactory.decodeResource(context.getResources(),R.drawable.bg);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			logic();
			draw();
			try {
				Thread.sleep((long)stepTime * 1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	public boolean OnTouchEvent(MotionEvent event){
		if(isDown == false){
			
		}
		return true;
	}
	//创建view与游戏初始化
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		bodyJimu[0] = createMyTile(0,0,bmpBg[0].getWidth(),bmpBg[0].getHeight(),0,1,bmpBg[0]);
		for (int i = 1; i < 5; i++) {
			bodyJimu[i] = createMyTile((i-1)*bmpBg[1].getWidth()+bmpBg[0].getWidth(),0,bmpBg[i].getWidth(),bmpBg[i].getHeight(),0,1,bmpBg[i]);
		}
		for (int j = 5; j < 9; j++) {
			bodyJimu[j] = createMyTile((j-5)*bmpBg[0].getWidth(),bmpBg[0].getHeight(),bmpBg[j].getWidth(),bmpBg[j].getHeight(),0,1,bmpBg[j]);
		}
		//添加四个矩形的框的body，以防止积木掉出屏幕
		createPolygon(0,getHeight(),getWidth(),10,0,0);
		createPolygon(0,0,getWidth(),10,0,0);
		createPolygon(0,0,10,getHeight(),0,0);
		createPolygon(getWidth(),0,10,getHeight(),0,0);
		th = new Thread(this);
		flag = true;
		th.start();
		
	}
	//创建每个积木的方法
	public Body createMyTile(float x,float y,float w,float h,float angle,float density,Bitmap bmp){
		/**
		 * 创建矩形Body的方法
		 * x:x的坐标
		 * y:y的坐标
		 * w:控件的宽度
		 * h:控件的高度
		 * angle:控件的角度
		 * density:控件的密度
		 * */
		PolygonDef pd = new PolygonDef();//创建多边形的对象
		pd.density = density;//多边形的密度
		pd.friction = 0.8f;//多边形的摩擦力
		pd.restitution = 0.3f;//多边形的恢复力
		pd.setAsBox(w / 2 / RATE, h / 2 / RATE);//setAsBox(float hx,float hy)方法：把多边形设置成矩形形状
		pd.filter.groupIndex = 2;
		BodyDef bd = new BodyDef();//创建一个刚体描述的对象
		bd.position.set((x + w / 2) / RATE, (y + h / 2) / RATE);
		bd.angle = (float)(angle*Math.PI/180);
		Body body = world.createBody(bd);
		body.m_userData = new MyTile(x,y,w,h,bmp);
		body.createShape(pd);
		body.setMassFromShapes();
		return body;
	}
	//创建四个矩形框的方法
	public Body createPolygon(float x,float y,float w,float h,float angle,float density){
		/**
		 * 创建矩形Body的方法
		 * x:x的坐标
		 * y:y的坐标
		 * w:控件的宽度
		 * h:控件的高度
		 * angle:控件的角度
		 * density:控件的密度
		 * */
		PolygonDef pd = new PolygonDef();//创建多边形的对象
		pd.density = density;//多边形的密度
		pd.friction = 0.8f;//多边形的摩擦力
		pd.restitution = 0.3f;//多边形的恢复力
		pd.setAsBox(w/2/RATE, h/2/RATE);
		BodyDef bd = new BodyDef();
		bd.position.set((x+w/2)/RATE,(y+h/2)/RATE);
		bd.angle = (float)(angle*Math.PI/180);
		Body body = world.createBody(bd);
		body.m_userData = new MyRect(x,y,w,h);
		body.createShape(pd);//创建一个几何形状，将其添加到刚体中
		body.setMassFromShapes();//根据密度及几何形状自动计算该刚体的质量
		return body;
	}
	//绘制函数
	public void draw(){
		try {
			//获取画布实例
			canvas = sfh.lockCanvas();
			//刷屏
			canvas.drawColor(Color.BLACK);
			//绘制游戏背景
			canvas.drawBitmap(bmpBackground, 0, -Math.abs(getHeight() - bmpBackground.getHeight()), paint);
			//遍历绘制Body
			Body body = world.getBodyList();
			for (int i = 1; i < world.getBodyCount(); i++) {
				if((body.m_userData) instanceof MyRect){
					MyRect rect = (MyRect)(body.m_userData);
					rect.drawRect(canvas, paint);
				}else if((body.m_userData) instanceof MyTile){
					MyTile tile = (MyTile)(body.m_userData);
					tile.drawMyTile(canvas, paint);
				}
				body = body.m_next;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try{
				if(canvas != null){
					sfh.unlockCanvasAndPost(canvas);
				}
			}catch (Exception e2){
				
			}
		}
	}
	//逻辑处理函数
	private void logic(){
		//物理世界模拟
		world.step(stepTime, iteraTions);
		//遍历Body，进行Body与图形之间的数据传递
		Body body = world.getBodyList();
		for (int i = 1; i < world.getBodyCount(); i++) {
			if((body.m_userData) instanceof MyRect){
				MyRect rect = (MyRect)(body.m_userData);
				rect.setX(body.getPosition().x * RATE - rect.getW() / 2);
				rect.setY(body.getPosition().y * RATE - rect.getH() / 2);
				rect.setAngle((float) (body.getAngle() * 180 / Math.PI));
			}else if((body.m_userData) instanceof MyTile){
				//判定m_userData中的数据是否为MyTile实例
				MyTile tile = (MyTile) (body.m_userData);
				tile.setX(body.getPosition().x * RATE - tile.getW() / 2);
				tile.setY(body.getPosition().y * RATE - tile.getH() / 2);
				tile.setAngle((float) (body.getAngle() * 180 / Math.PI));
			}
			body = body.m_next;
		}
		//动态Body是否下落
		if(isDown == true){
			isDownCount++;
		}
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		flag = false;
	}
	
}
