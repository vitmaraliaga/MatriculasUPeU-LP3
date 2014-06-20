package com.example.matriculaap;

import java.util.ArrayList;

import com.example.list.ProcesoAdapter;
import com.example.model.Proceso;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;


public class MainEnProceso extends MainBaseMenu {
	
	private ListView lvProcesos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_en_proceso);
		lvProcesos = (ListView) findViewById(R.id.lvProcesos);
		new procesoSearch().execute();
	}
	public void updateListView(ArrayList<Proceso> procesos) {
		lvProcesos
				.setAdapter(new ProcesoAdapter(this, R.layout.row_proceso, procesos));
	}
	class procesoSearch extends AsyncTask<Object, Void, ArrayList<Proceso>> {

		
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			dialog = new ProgressDialog(MainEnProceso.this);
			dialog.setMessage(getResources().getString(
					R.string.label_tweet_search_loader));
			dialog.show();

		}
		
		@Override
		protected ArrayList<Proceso> doInBackground(Object... params) {
			ArrayList<Proceso> procesos= new ArrayList<Proceso>();
			try {
				for (int i = 0; i < 11; i++) {
					Proceso proceso= new Proceso();
					proceso.setNombre("proceso "+i);
					proceso.setCantidad("20 "+i);
					proceso.setPorcentaje("100 %");
					procesos.add(proceso);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			// TODO Auto-generated method stub
			return procesos;
		}
		@Override
		protected void onPostExecute(ArrayList<Proceso> procesos) {
			// TODO Auto-generated method stub
			super.onPostExecute(procesos);
			dialog.dismiss();
			if(procesos.isEmpty()){
				Toast.makeText(
						MainEnProceso.this, 
						getResources().getString(
								R.string.label_tweets_not_found), 
						Toast.LENGTH_SHORT).show();
			}else {
				updateListView(procesos);
			}
		}
		
	}
}
