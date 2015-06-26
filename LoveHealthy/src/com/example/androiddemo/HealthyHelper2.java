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
		if(texttheme1.equals("感冒")){
			textinfo.setText("上呼吸道感染简称上感，又称普通感冒。是包括鼻腔、咽或喉部急性炎症的总称。广义的上感不是一个疾病诊断，而是一组疾病，包括普通感冒、病毒性咽炎、喉炎、疱疹性咽峡炎、咽结膜热、细菌性咽-扁桃体炎。狭义的上感又称普通感冒，是最常见的急性呼吸道感染性疾病，多呈自限性，但发生率较高。成人每年发生2～4次，儿童发生率更高，每年6～8次。全年皆可发病，冬春季较多。");
		}else if(texttheme1.equals("发烧")){
			textinfo.setText("发烧 即 发热 （医学术语） 。医学术语，又称发烧。由于致热原的作用使体温调定点上移而引起的调节性体温升高（超过0.5℃）,称为发热。每个人的正常体温略有不同，而且受许多因素（时间、季节、环境、月经等）的影响。因此判定是否发热，最好是和自己平时同样条件下的体温相比较。如不知自己原来的体温，则腋窝体温（检测10分钟）超过37.4℃可定为发热。无需惊慌");
		}else if(texttheme1.equals("鼻炎")){
			textinfo.setText("鼻炎即鼻腔炎性疾病，是病毒、细菌、变应原、各种理化因子以及某些全身性疾病引起的鼻腔黏膜的炎症。鼻炎的主要病理改变是鼻腔黏膜充血、肿胀、渗出、增生、萎缩或坏死等。");
		}else if(texttheme1.equals("过敏")){
			textinfo.setText("过敏，有机体对某些药物或外界刺激的感受性不正常地增高的现象，药物过敏。过敏简单地说就是对某种物质过敏。当你吃下、摸到或吸入某种物质的时候，身体会产生过度的反应；导致这种反应的物质就是所谓的“过敏原”。在正常的情况下，身体会制造抗体用来保护身体不受疾病的侵害；但过敏者的身体却会将正常无害的物质误认为是有害的东西，产生抗体，这种物质就成为一种“过敏原”。");
		}else if(texttheme1.equals("慢性咽炎")){
			textinfo.setText("慢性单纯性咽炎又称慢性咽炎，较多见。病变主要在黏膜层，表现为咽部黏膜慢性充血，其血管周围有较多淋巴细胞浸润，也可见白细胞及浆细胞浸润。黏膜及黏膜下结缔组织增生。黏液腺可肥大，分泌功能亢进，黏液分泌增多。多见成年人，病程长，易复发。");
		}else{
			textinfo.setText("下一个版本我们将会完善该功能");
		}
	}
}
