package com.example.matriculaap;

import java.util.ArrayList;

import com.example.list.FacultadAdapter;
import com.example.model.Facultad;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainPorFacultades extends MainBaseMenu  {

	private ListView lvFacultades;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_facultades);
		
		lvFacultades=(ListView) findViewById(R.id.lvFacultades);
		Button btnFaculEstadis = (Button) findViewById(R.id.btnFaculEstadis);
	   new facultadSearch().execute();
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
public void updateListView(ArrayList<Facultad> facultades){
	lvFacultades
	.setAdapter(new FacultadAdapter(this, R.layout.row_facultad, facultades));
	
}
	
class facultadSearch extends AsyncTask<Object, Void, ArrayList<Facultad>> {

	ProgressDialog dialog;
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		dialog = new ProgressDialog(MainPorFacultades.this);
		dialog.setMessage(getResources().getString(R.string.label_tweet_search_loader));
		dialog.show();
	}
	
	@Override
	protected ArrayList<Facultad> doInBackground(Object... params) {
		ArrayList<Facultad> facultades= new ArrayList<Facultad>();
		try {
			for (int i = 0; i < 4; i++) {
				Facultad facultad= new Facultad();
				facultad.setNombreFacultad("FACULTAD---"+i);
				facultad.setCantidad(i+"00");
				facultad.setPorcentaje(i+"0 %");
				facultades.add(facultad);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return facultades;
	}
	@Override
	protected void onPostExecute(ArrayList<Facultad> facultades) {
		// TODO Auto-generated method stub
		super.onPostExecute(facultades);
		dialog.dismiss();
		if (facultades.isEmpty()) {
			Toast.makeText(MainPorFacultades.this, 
					getResources().getString(R.string.label_tweets_not_found), 
					Toast.LENGTH_SHORT).show();
			
		}else{
			updateListView(facultades);
		}
	}
}

}
