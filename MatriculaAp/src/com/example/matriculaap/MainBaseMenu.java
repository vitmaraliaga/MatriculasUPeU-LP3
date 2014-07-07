package com.example.matriculaap;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.MenuItem;


public class MainBaseMenu extends Activity {

//	private MainActivity m= new MainActivity();
//	private MainEnProceso p= new MainEnProceso();
//	private MainPorEscuelas e= new MainPorEscuelas();
//	private MainPorFacultades f= new MainPorFacultades();
//	private MainPorResidencia r= new MainPorResidencia();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
//		
//		Typeface miFuente= Typeface.createFromAsset(getAssets(),"fonts/acmesab.TTF");
//		TextView txt= (TextView) findViewById(R.id.tituloMain);
//		txt.setTypeface(miFuente);
	}	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_base_menu, menu);				
		
		return true;
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		  Intent action;
		   switch (item.getItemId()) {
		
		case R.id.menuInicio:
			action = new Intent(getApplicationContext(),
					MainActivity.class);
			startActivity(action);
//			Toast.makeText(getApplicationContext()
//					, "pantalla inicio"
//					, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menuFacultades:
			action = new Intent(getApplicationContext(),
					MainPorFacultades.class);
			startActivity(action);
//			Toast.makeText(getApplicationContext()
//					, "pantalla por facultades"
//					, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menuEscuelas:			
			action = new Intent(getApplicationContext(),
					MainPorEscuelas.class);
			startActivity(action);
//			Toast.makeText(getApplicationContext()
//					, "pantalla por escuelas"
//					, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menuProceso:
			action = new Intent(getApplicationContext(),
					MainEnProceso.class);
			startActivity(action);
			return true;
		case R.id.menuSalir:
			finish();
//			m.ma.finish();
//			p.pro.finish();
//			e.es.finish();
//			r.re.finish();
//			f.fa.finish();
			
			
			
			//Intent salida = new Intent(Intent.ACTION_MAIN);finish(); 
			
			return true;
		
		default:   

		return super.onOptionsItemSelected(item);
	}
	}

}
