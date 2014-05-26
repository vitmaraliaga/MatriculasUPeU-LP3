package com.example.matriculaap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPorResidencia extends MainBaseMenu  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_residencia);
		Button btnResidEstadis= (Button) findViewById(R.id.btnResidEstadis);
		
		btnResidEstadis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				Intent i= new Intent(
						getApplicationContext(),MainPorResidenciaEstadis.class);
				startActivity(i);
				// TODO Auto-generated method stub
				
			}
		});
	}
}
