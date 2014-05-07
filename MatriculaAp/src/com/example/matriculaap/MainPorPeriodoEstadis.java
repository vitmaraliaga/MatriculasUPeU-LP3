package com.example.matriculaap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainPorPeriodoEstadis extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Prueba
		setContentView(R.layout.activity_main_por_periodo_estadis);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_por_periodo_estadis, menu);
		return true;
	}

}
