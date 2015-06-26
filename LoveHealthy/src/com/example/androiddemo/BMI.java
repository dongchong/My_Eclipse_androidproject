package com.example.androiddemo;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class BMI extends Activity{
	MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bmi);
        findViews();
        setListeners();
        dbHelper = new MyDatabaseHelper(this,"bmi_data",1);
    }
    private ImageView button;
    private ImageView button2,button3;
    private EditText field_height;
    private EditText field_weight;
    private TextView view_result;
    private TextView view_suggest;
    private ImageView imageView4;
    private double bmi;
    private void findViews() {
		// TODO �Զ����ɵķ������
		button = (ImageView)findViewById(R.id.imageView2);
		button2 = (ImageView)findViewById(R.id.imageView6);
		button3 = (ImageView)findViewById(R.id.imageView7);
		field_height = (EditText)findViewById(R.id.editText1);
		field_weight = (EditText)findViewById(R.id.editText2);
		view_result = (TextView)findViewById(R.id.result);
		view_suggest = (TextView)findViewById(R.id.suggest);
		imageView4 = (ImageView)findViewById(R.id.imageView4);
	}
	private void setListeners() {
		// TODO �Զ����ɵķ������
		button.setOnClickListener(calBMI);
		button2.setOnClickListener(baocun);
		button3.setOnClickListener(qingkong);
		imageView4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent();
				intent.setClass(BMI.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
	private Button.OnClickListener baocun = new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			//��ȡ�û�������
			String height = ((EditText)findViewById(R.id.editText1)).getText().toString();
			String weight = ((EditText)findViewById(R.id.editText2)).getText().toString();
			//����ߡ����ش������ݿ�
			insertData(dbHelper.getReadableDatabase(),height,weight);
			Toast.makeText(BMI.this, "������Ϣ�ɹ�", 8000).show();
		}
		
	};
	private Button.OnClickListener qingkong = new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			field_height.setText("");
			field_weight.setText("");
			view_result.setText("");
			view_suggest.setText("");
		}
		
	};
	private Button.OnClickListener calBMI = new Button.OnClickListener(){
		@Override
		public void onClick(View v){
			DecimalFormat nf = new DecimalFormat("0.0");
			try {
				double height = Double.parseDouble(field_height.getText().toString())/100;
				double weight = Double.parseDouble(field_weight.getText().toString());
				bmi = weight / (height * height);
				if (height<=0||weight<=0) {
					Toast.makeText(BMI.this, "�������߻����ز���С�ڵ���0����", Toast.LENGTH_LONG).show();
				}else{
					view_result.setText(getText(R.string.bmi_result) + nf.format(bmi));
					if (bmi>30) {
						showNotification(bmi);
						view_suggest.setText(R.string.advice_tooweight);
					}else if(bmi>24){
						view_suggest.setText(R.string.advice_weight);
					}else if(bmi<18.5){
						view_suggest.setText(R.string.advice_thin);
					}else{
						view_suggest.setText(R.string.advice_average);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(BMI.this, "ֻ����������Ŷ������", Toast.LENGTH_LONG).show();
			}
		}
	};
	protected void showNotification(double BMI){
		NotificationManager barManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		Notification barMsg = new Notification(R.drawable.icon,"���������Ѿ����س��꣡����",System.currentTimeMillis());
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this,BMI.class), PendingIntent.FLAG_UPDATE_CURRENT);
		barMsg.setLatestEventInfo(BMI.this, "����BMI̫����", "����֪ͨ��ĸ����", contentIntent);
		barManager.notify(0,barMsg);
	}
	private void insertData(SQLiteDatabase db,String height,String weight){
		db.execSQL("insert into data values(null,?,?)",new String[]{height,weight});
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
		if (dbHelper != null) {
			dbHelper.close();
		}
	}
}