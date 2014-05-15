package com.example.matriculaap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainPorPeriodo extends MainBaseMenu {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_periodo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_por_periodo, menu);
		return true;
	}

}
