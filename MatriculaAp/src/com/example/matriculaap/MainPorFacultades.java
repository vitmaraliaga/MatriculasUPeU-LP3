package com.example.matriculaap;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPorFacultades extends MainBaseMenu  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_facultades);
		
		Button btnFaculEstadis = (Button) findViewById(R.id.btnFaculEstadis);
	
		btnFaculEstadis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
			Intent i= new Intent(getApplicationContext(),
					MainPorFacultadesEstadis.class);	
			startActivity(i);
				
				// TODO Auto-generated method stub
				
			}
		});
	}

	


}
