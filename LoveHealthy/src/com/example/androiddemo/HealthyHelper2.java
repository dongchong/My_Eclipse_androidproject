package com.example.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class HealthyHelper2 extends Activity{
	private TextView texttheme,textinfo;
	private String texttheme1;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthhelper2);
		texttheme = (TextView)findViewById(R.id.texttheme);
		textinfo = (TextView)findViewById(R.id.textinfo);
		Bundle bundle = this.getIntent().getExtras();
		texttheme1 = bundle.getString("TEXT");
		texttheme.setText(texttheme1);
		if(texttheme1.equals("��ð")){
			textinfo.setText("�Ϻ�������Ⱦ����ϸУ��ֳ���ͨ��ð���ǰ�����ǻ���ʻ��������֢���ܳơ�������ϸв���һ��������ϣ�����һ�鼲����������ͨ��ð�����������ס����ס���������Ͽ�ס��ʽ�Ĥ�ȡ�ϸ������-�������ס�������ϸ��ֳ���ͨ��ð��������ļ��Ժ�������Ⱦ�Լ�������������ԣ��������ʽϸߡ�����ÿ�귢��2��4�Σ���ͯ�����ʸ��ߣ�ÿ��6��8�Ρ�ȫ��Կɷ������������϶ࡣ");
		}else if(texttheme1.equals("����")){
			textinfo.setText("���� �� ���� ��ҽѧ��� ��ҽѧ����ֳƷ��ա���������ԭ������ʹ���µ��������ƶ�����ĵ������������ߣ�����0.5�棩,��Ϊ���ȡ�ÿ���˵������������в�ͬ��������������أ�ʱ�䡢���ڡ��������¾��ȣ���Ӱ�졣����ж��Ƿ��ȣ�����Ǻ��Լ�ƽʱͬ�������µ�������Ƚϡ��粻֪�Լ�ԭ�������£���Ҹ�����£����10���ӣ�����37.4��ɶ�Ϊ���ȡ����辪��");
		}else if(texttheme1.equals("����")){
			textinfo.setText("���׼���ǻ���Լ������ǲ�����ϸ������Ӧԭ�������������Լ�ĳЩȫ���Լ�������ı�ǻ�Ĥ����֢�����׵���Ҫ����ı��Ǳ�ǻ�Ĥ��Ѫ�����͡�������������ή�������ȡ�");
		}else if(texttheme1.equals("����")){
			textinfo.setText("�������л����ĳЩҩ������̼��ĸ����Բ����������ߵ�����ҩ������������򵥵�˵���Ƕ�ĳ�����ʹ�����������¡�����������ĳ�����ʵ�ʱ�������������ȵķ�Ӧ���������ַ�Ӧ�����ʾ�����ν�ġ�����ԭ����������������£���������쿹�������������岻�ܼ������ֺ����������ߵ�����ȴ�Ὣ�����޺�����������Ϊ���к��Ķ������������壬�������ʾͳ�Ϊһ�֡�����ԭ����");
		}else if(texttheme1.equals("��������")){
			textinfo.setText("���Ե����������ֳ��������ף��϶����������Ҫ���Ĥ�㣬����Ϊ�ʲ��Ĥ���Գ�Ѫ����Ѫ����Χ�н϶��ܰ�ϸ������Ҳ�ɼ���ϸ������ϸ�������Ĥ���Ĥ�½����֯�������Һ�ٿɷʴ󣬷��ڹ��ܿ������Һ�������ࡣ��������ˣ����̳����׸�����");
		}else{
			textinfo.setText("��һ���汾���ǽ������Ƹù���");
		}
	}
}
