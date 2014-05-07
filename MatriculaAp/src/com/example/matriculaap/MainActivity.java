package com.example.matriculaap;

import java.security.Principal;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

// Jhon Ccaypani Vasquez !!


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
   @Override
public boolean onOptionsItemSelected(MenuItem item) {
	  Intent action;
	   switch (item.getItemId()) {
	
	case R.id.inicio:
		action = new Intent(getApplicationContext(),
				MainActivity.class);
		startActivity(action);
//		Toast.makeText(getApplicationContext()
//				, "pantalla inicio"
//				, Toast.LENGTH_SHORT).show();
		return true;
	case R.id.por_facultades:
		action = new Intent(getApplicationContext(),
				MainPorFacultades.class);
		startActivity(action);
//		Toast.makeText(getApplicationContext()
//				, "pantalla por facultades"
//				, Toast.LENGTH_SHORT).show();
		return true;
	case R.id.por_escuelas:
		
		action = new Intent(getApplicationContext(),
				MainPorEscuelas.class);
		startActivity(action);
//		Toast.makeText(getApplicationContext()
//				, "pantalla por escuelas"
//				, Toast.LENGTH_SHORT).show();
		return true;
	case R.id.por_tipo_de_residencia:
		action = new Intent(getApplicationContext(),
				MainPorResidencia.class);
		startActivity(action);
	
//		Toast.makeText(getApplicationContext()
//				, "pantalla por residencia"
//				, Toast.LENGTH_SHORT).show();
		return true;
	case R.id.por_periodo:
		action = new Intent(getApplicationContext(),
				MainPorPeriodo.class);
		startActivity(action);
		return true;
	case R.id.salir:
		finish();
		return true;
	
	default:   
	   // TODO Auto-generated method stub
		// Ronald zela comentario
	return super.onOptionsItemSelected(item);
}
}
}
