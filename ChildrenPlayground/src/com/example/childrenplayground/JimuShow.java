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
 * �������չʾ��ľ��һ����
 * �����ע�ͱȽ��٣�ÿһ�ж�������Ӣ���ǲ��ţ���������ϸ��ע��
 * */
public class JimuShow extends SurfaceView implements Callback,Runnable{
	private Thread th;
	private SurfaceHolder sfh;
	private Canvas canvas;
	private Paint paint;
	private boolean flag;
	public Context context;
	//���һ����������
	private float RATE = 30;
	private World world;
	private float stepTime = 1f/60f;//��������ģ���Ƶ��
	private int iteraTions = 10;//����ֵ������ֵԽ��ģ��Խ��ȷ������Ч��Խ��
	//����ͼ
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
		//ÿ����ľ����ľ���ͼƬ��ɵĻ�ľ
		bmpBg = new Bitmap[9];
		bodyJimu = new Body[9];
		this.context = context;
		this.setKeepScreenOn(true);//������Ļ����״̬
		sfh = this.getHolder();//SurfaceHolder�൱��SurfaceView��һ����������ͨ��this.getHolder()������SurfaceView
		sfh.addCallback(this);//ΪSurfaceholder���һ��SurfaceHolder.addCallback()�Ļص��ӿ�
		paint = new Paint();//����һ������
		paint.setStyle(Style.STROKE);
		setFocusable(true);//���ÿؼ��ɵ��
		setFocusableInTouchMode(true);//�����Ƿ��ý���
		//�����������
		AABB aabb = new AABB();
		//������������Ͻ�����
		aabb.lowerBound = new Vec2(-100,-100);
		//������������½�����//Vec2��ʾһ����ά����
		aabb.upperBound = new Vec2(100,100);
		Vec2 gravity = new Vec2(0,10);//���������������������Ķ���
		world = new World(aabb,gravity,true);
		//ʵ����ÿ����ľ����
		for (int i = 0; i < bmpBg.length; i++) {
			bmpBg[i] = BitmapFactory.decodeResource(context.getResources(), bmp[i]);
		}
		//ʵ��������ͼƬ
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
	//����view����Ϸ��ʼ��
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		bodyJimu[0] = createMyTile(0,0,bmpBg[0].getWidth(),bmpBg[0].getHeight(),0,1,bmpBg[0]);
		for (int i = 1; i < 5; i++) {
			bodyJimu[i] = createMyTile((i-1)*bmpBg[1].getWidth()+bmpBg[0].getWidth(),0,bmpBg[i].getWidth(),bmpBg[i].getHeight(),0,1,bmpBg[i]);
		}
		for (int j = 5; j < 9; j++) {
			bodyJimu[j] = createMyTile((j-5)*bmpBg[0].getWidth(),bmpBg[0].getHeight(),bmpBg[j].getWidth(),bmpBg[j].getHeight(),0,1,bmpBg[j]);
		}
		//����ĸ����εĿ��body���Է�ֹ��ľ������Ļ
		createPolygon(0,getHeight(),getWidth(),10,0,0);
		createPolygon(0,0,getWidth(),10,0,0);
		createPolygon(0,0,10,getHeight(),0,0);
		createPolygon(getWidth(),0,10,getHeight(),0,0);
		th = new Thread(this);
		flag = true;
		th.start();
		
	}
	//����ÿ����ľ�ķ���
	public Body createMyTile(float x,float y,float w,float h,float angle,float density,Bitmap bmp){
		/**
		 * ��������Body�ķ���
		 * x:x������
		 * y:y������
		 * w:�ؼ��Ŀ��
		 * h:�ؼ��ĸ߶�
		 * angle:�ؼ��ĽǶ�
		 * density:�ؼ����ܶ�
		 * */
		PolygonDef pd = new PolygonDef();//��������εĶ���
		pd.density = density;//����ε��ܶ�
		pd.friction = 0.8f;//����ε�Ħ����
		pd.restitution = 0.3f;//����εĻָ���
		pd.setAsBox(w / 2 / RATE, h / 2 / RATE);//setAsBox(float hx,float hy)�������Ѷ�������óɾ�����״
		pd.filter.groupIndex = 2;
		BodyDef bd = new BodyDef();//����һ�����������Ķ���
		bd.position.set((x + w / 2) / RATE, (y + h / 2) / RATE);
		bd.angle = (float)(angle*Math.PI/180);
		Body body = world.createBody(bd);
		body.m_userData = new MyTile(x,y,w,h,bmp);
		body.createShape(pd);
		body.setMassFromShapes();
		return body;
	}
	//�����ĸ����ο�ķ���
	public Body createPolygon(float x,float y,float w,float h,float angle,float density){
		/**
		 * ��������Body�ķ���
		 * x:x������
		 * y:y������
		 * w:�ؼ��Ŀ��
		 * h:�ؼ��ĸ߶�
		 * angle:�ؼ��ĽǶ�
		 * density:�ؼ����ܶ�
		 * */
		PolygonDef pd = new PolygonDef();//��������εĶ���
		pd.density = density;//����ε��ܶ�
		pd.friction = 0.8f;//����ε�Ħ����
		pd.restitution = 0.3f;//����εĻָ���
		pd.setAsBox(w/2/RATE, h/2/RATE);
		BodyDef bd = new BodyDef();
		bd.position.set((x+w/2)/RATE,(y+h/2)/RATE);
		bd.angle = (float)(angle*Math.PI/180);
		Body body = world.createBody(bd);
		body.m_userData = new MyRect(x,y,w,h);
		body.createShape(pd);//����һ��������״��������ӵ�������
		body.setMassFromShapes();//�����ܶȼ�������״�Զ�����ø��������
		return body;
	}
	//���ƺ���
	public void draw(){
		try {
			//��ȡ����ʵ��
			canvas = sfh.lockCanvas();
			//ˢ��
			canvas.drawColor(Color.BLACK);
			//������Ϸ����
			canvas.drawBitmap(bmpBackground, 0, -Math.abs(getHeight() - bmpBackground.getHeight()), paint);
			//��������Body
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
	//�߼�������
	private void logic(){
		//��������ģ��
		world.step(stepTime, iteraTions);
		//����Body������Body��ͼ��֮������ݴ���
		Body body = world.getBodyList();
		for (int i = 1; i < world.getBodyCount(); i++) {
			if((body.m_userData) instanceof MyRect){
				MyRect rect = (MyRect)(body.m_userData);
				rect.setX(body.getPosition().x * RATE - rect.getW() / 2);
				rect.setY(body.getPosition().y * RATE - rect.getH() / 2);
				rect.setAngle((float) (body.getAngle() * 180 / Math.PI));
			}else if((body.m_userData) instanceof MyTile){
				//�ж�m_userData�е������Ƿ�ΪMyTileʵ��
				MyTile tile = (MyTile) (body.m_userData);
				tile.setX(body.getPosition().x * RATE - tile.getW() / 2);
				tile.setY(body.getPosition().y * RATE - tile.getH() / 2);
				tile.setAngle((float) (body.getAngle() * 180 / Math.PI));
			}
			body = body.m_next;
		}
		//��̬Body�Ƿ�����
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
