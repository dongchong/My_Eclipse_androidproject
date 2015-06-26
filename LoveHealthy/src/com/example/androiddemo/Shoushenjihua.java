package com.example.androiddemo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
public class Shoushenjihua extends Activity{
	private EditText Text1;
	private EditText Text2;
	private Spinner date;
	private ImageView back;
	private ImageView next;
	public String riqi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shoushenjihua);
        back = (ImageView)findViewById(R.id.before);
        next = (ImageView)findViewById(R.id.next);
		Text1 = (EditText)findViewById(R.id.editText1);
		Text2 = (EditText)findViewById(R.id.editText2);
		date = (Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.date, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		date.setAdapter(adapter);
        back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent in = new Intent();
				in.setClass(Shoushenjihua.this,MainActivity.class);
				startActivity(in);
			}
		});
        next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if((Text1.getText().toString()).equals("")||(Text2.getText().toString()).equals("")){
					Toast.makeText(Shoushenjihua.this, "请先输入现在体重或目标体重", Toast.LENGTH_LONG).show();
				}else{
					Intent in = new Intent();
					in.setClass(Shoushenjihua.this,Report.class);
					Bundle bundle = new Bundle();
					bundle.putString("XIANZAI", Text1.getText().toString());
					bundle.putString("MUBIAO",Text2.getText().toString());
					bundle.putString("RIQI",riqi);
					in.putExtras(bundle);
					startActivity(in);
				}
			}
		});
        date.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int arg2, long arg3) {
				// TODO 自动生成的方法存根
				riqi = Shoushenjihua.this.getResources().getStringArray(R.array.date)[arg2];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO 自动生成的方法存根	
			}
        	
		});
		
    }
}
