package com.example.childrenplayground;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
//实现SensorEventListener的功能是：当安卓的传感器资源发成变化时传感器管理器会给出通知
public class WaWa extends Activity implements SensorEventListener{
	/**
	 * 这个类是娃娃这一功能的实现类，主要是用到了安卓的传感器资源，摇晃手机则是通过安卓的震动服务来感应
	 */
	//首先定义一个传感器设备管理器
	private SensorManager mSensorManager;
	private ImageView imageView;
	//alpha为图片透明度的参数，默认为0（全黑）
	private float alpha = 0;
	int i = 0;
	private MediaPlayer mMediaPlayer;
	private int image[] = {R.drawable.wawa_xiaohai_1,R.drawable.wawa_xiaohai_2,R.drawable.wawa_xiaohai_3,
			R.drawable.wawa_xiaohai_4,R.drawable.wawa_xiaohai_5,R.drawable.wawa_xiaohai_6,R.drawable.wawa_xiaohai_7,
			R.drawable.wawa_xiaohai_8,R.drawable.wawa_xiaohai_9,R.drawable.wawa_xiaohai_90,R.drawable.wawa_xiaohai_91};
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wawa);
		//调用系统的传感器服务
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.setAlpha(alpha);
		mMediaPlayer = MediaPlayer.create(WaWa.this, R.raw.wawa_raw_bengkui);
		mMediaPlayer.start();
	}
	//onResume()和onStop()都是Activity的方法
	//onResume()：当用户从pause状态回到activity，系统将会调用onResume()方法
	//onPause():暂停你的Activity，但是并没有被stop。。。
	public void onResume(){
		super.onResume();
		//SensorManager中的registerListener(SensorEventListener listener, Sensor sensor, int rate)方法:注册一个SensorListener的感应器
		/*SensorManager中的getDefaultSensor(int type)方法：使用此方法获取给定类型的默认传感器。注意，返回的传感器可复合传感器，其平均数据或筛选。
			如果需要访问原始的传感器使用getSensorList。*/
		mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
	}
	public void onStop(){
		//一定要记得最后Activity关闭的时候对所有传感器的监听器进行注销。。。类似于IO流中的关流，不然会耗费系统资源
		mSensorManager.unregisterListener(this);
		mMediaPlayer.stop();
		super.onStop();
	}
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// 传感器的准确性改变时调用该方法
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// 传感器的值发成变化时调用
		int sensorType = event.sensor.getType();
		//values[0]表示x轴，values[1]表示Y轴，values[2]：Z轴
		float[] values = event.values;
		//此处判断的是如果sensorType是速度传感器的时候，Sensor.TYPE_ACCELEROMETER
		if (sensorType == Sensor.TYPE_ACCELEROMETER) {
			//设置imageView的透明度
			imageView.setAlpha((values[0])*10);
			if (Math.abs(values[0])>14 || Math.abs(values[1])>14 || Math.abs(values[2])>14) {
				imageView.setBackgroundResource(image[i]);
				imageView.setAlpha(values[0]*10);
			}
			i=(i+1)%11;
		}
	}
}
