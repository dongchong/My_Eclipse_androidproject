package com.example.childrenplayground;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
//ʵ��SensorEventListener�Ĺ����ǣ�����׿�Ĵ�������Դ���ɱ仯ʱ�����������������֪ͨ
public class WaWa extends Activity implements SensorEventListener{
	/**
	 * �������������һ���ܵ�ʵ���࣬��Ҫ���õ��˰�׿�Ĵ�������Դ��ҡ���ֻ�����ͨ����׿���𶯷�������Ӧ
	 */
	//���ȶ���һ���������豸������
	private SensorManager mSensorManager;
	private ImageView imageView;
	//alphaΪͼƬ͸���ȵĲ�����Ĭ��Ϊ0��ȫ�ڣ�
	private float alpha = 0;
	int i = 0;
	private MediaPlayer mMediaPlayer;
	private int image[] = {R.drawable.wawa_xiaohai_1,R.drawable.wawa_xiaohai_2,R.drawable.wawa_xiaohai_3,
			R.drawable.wawa_xiaohai_4,R.drawable.wawa_xiaohai_5,R.drawable.wawa_xiaohai_6,R.drawable.wawa_xiaohai_7,
			R.drawable.wawa_xiaohai_8,R.drawable.wawa_xiaohai_9,R.drawable.wawa_xiaohai_90,R.drawable.wawa_xiaohai_91};
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wawa);
		//����ϵͳ�Ĵ���������
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.setAlpha(alpha);
		mMediaPlayer = MediaPlayer.create(WaWa.this, R.raw.wawa_raw_bengkui);
		mMediaPlayer.start();
	}
	//onResume()��onStop()����Activity�ķ���
	//onResume()�����û���pause״̬�ص�activity��ϵͳ�������onResume()����
	//onPause():��ͣ���Activity�����ǲ�û�б�stop������
	public void onResume(){
		super.onResume();
		//SensorManager�е�registerListener(SensorEventListener listener, Sensor sensor, int rate)����:ע��һ��SensorListener�ĸ�Ӧ��
		/*SensorManager�е�getDefaultSensor(int type)������ʹ�ô˷�����ȡ�������͵�Ĭ�ϴ�������ע�⣬���صĴ������ɸ��ϴ���������ƽ�����ݻ�ɸѡ��
			�����Ҫ����ԭʼ�Ĵ�����ʹ��getSensorList��*/
		mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
	}
	public void onStop(){
		//һ��Ҫ�ǵ����Activity�رյ�ʱ������д������ļ���������ע��������������IO���еĹ�������Ȼ��ķ�ϵͳ��Դ
		mSensorManager.unregisterListener(this);
		mMediaPlayer.stop();
		super.onStop();
	}
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// ��������׼ȷ�Ըı�ʱ���ø÷���
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// ��������ֵ���ɱ仯ʱ����
		int sensorType = event.sensor.getType();
		//values[0]��ʾx�ᣬvalues[1]��ʾY�ᣬvalues[2]��Z��
		float[] values = event.values;
		//�˴��жϵ������sensorType���ٶȴ�������ʱ��Sensor.TYPE_ACCELEROMETER
		if (sensorType == Sensor.TYPE_ACCELEROMETER) {
			//����imageView��͸����
			imageView.setAlpha((values[0])*10);
			if (Math.abs(values[0])>14 || Math.abs(values[1])>14 || Math.abs(values[2])>14) {
				imageView.setBackgroundResource(image[i]);
				imageView.setAlpha(values[0]*10);
			}
			i=(i+1)%11;
		}
	}
}
