package com.example.matriculaap;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPorPeriodo extends MainBaseMenu {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_periodo);
		Button btnPeriodoEstadis = (Button) findViewById(R.id.btnPeriodoEstadis);
		btnPeriodoEstadis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						MainPorPeriodoEstadis.class);
				startActivity(i);
			}
		});
			
	}


}
