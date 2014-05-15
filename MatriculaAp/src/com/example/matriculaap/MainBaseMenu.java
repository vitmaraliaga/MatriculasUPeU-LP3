package com.example.matriculaap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainBaseMenu extends Activity {


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_base_menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		  Intent action;
		   switch (item.getItemId()) {
		
		case R.id.inicio:
			action = new Intent(getApplicationContext(),
					MainActivity.class);
			startActivity(action);
//			Toast.makeText(getApplicationContext()
//					, "pantalla inicio"
//					, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.por_facultades:
			action = new Intent(getApplicationContext(),
					MainPorFacultades.class);
			startActivity(action);
//			Toast.makeText(getApplicationContext()
//					, "pantalla por facultades"
//					, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.por_escuelas:
			
			action = new Intent(getApplicationContext(),
					MainPorEscuelas.class);
			startActivity(action);
//			Toast.makeText(getApplicationContext()
//					, "pantalla por escuelas"
//					, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.por_tipo_de_residencia:
			action = new Intent(getApplicationContext(),
					MainPorResidencia.class);
			startActivity(action);
		
//			Toast.makeText(getApplicationContext()
//					, "pantalla por residencia"
//					, Toast.LENGTH_SHORT).show();
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

		return super.onOptionsItemSelected(item);
	}
	}

}
