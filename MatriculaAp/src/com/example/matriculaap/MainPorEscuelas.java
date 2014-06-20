package com.example.matriculaap;

import java.util.ArrayList;

import com.example.list.EscuelaAdapter;
import com.example.model.Escuela;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainPorEscuelas extends MainBaseMenu {

	private ListView lvEscuelas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_escuelas);
		
		lvEscuelas = (ListView) findViewById(R.id.lvEscuelas);
		new escuelaSearch().execute();
		//Button btnEscueEstadis = new (Button) findViewById(R.id.)
	}
	public void updateListView(ArrayList<Escuela> escuelas){
		lvEscuelas
		.setAdapter(new EscuelaAdapter(this, R.layout.row_escuela, escuelas));
	
	}
	class escuelaSearch extends AsyncTask<Object, Void, ArrayList<Escuela>> {

		ProgressDialog dialog;
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		dialog = new ProgressDialog(MainPorEscuelas.this);
		dialog.setMessage(getResources().getString(
				R.string.label_tweet_search_loader));
		dialog.show();
	}
		@Override
		protected ArrayList<Escuela> doInBackground(Object... params) {
			ArrayList<Escuela> escuelas= new ArrayList<Escuela>();
			
			try {
				for (int i = 0; i < 21; i++) {
					Escuela escuela= new Escuela();
					escuela.setNombreEscuela("escuela........"+i);
					escuela.setCantidad("01"+i);
					escuela.setPorcentaje(i+"0 %");
					escuelas.add(escuela);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} 
			// TODO Auto-generated method stub
			return escuelas;
		}
		@Override
		protected void onPostExecute(ArrayList<Escuela> escuelas) {
			// TODO Auto-generated method stub
			super.onPostExecute(escuelas);
			
			dialog.dismiss();
			if(escuelas.isEmpty()){
				Toast.makeText(MainPorEscuelas.this, 
						getResources().getString(R.string.label_tweets_not_found), 
						Toast.LENGTH_SHORT).show();
				
				
			}else{
				updateListView(escuelas);
			}
		}
		
	}
	}
	

