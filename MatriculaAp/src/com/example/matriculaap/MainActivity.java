package com.example.matriculaap;



import android.os.Bundle;
import android.graphics.Typeface;
import android.widget.TextView;

//Jhon Ccaypani Vasquez !!

public class MainActivity extends MainBaseMenu {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Typeface miFuente= Typeface.createFromAsset(getAssets(),"fonts/acmesab.TTF");
		TextView txt= (TextView) findViewById(R.id.tituloMain);
		txt.setTypeface(miFuente);
	
		
	
	}	

}
