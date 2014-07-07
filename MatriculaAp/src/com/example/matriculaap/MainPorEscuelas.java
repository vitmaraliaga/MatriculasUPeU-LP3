package com.example.matriculaap;

import java.util.ArrayList;

import com.example.list.ListAdapter;
import com.example.model.Model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainPorEscuelas extends MainBaseMenu {

	private ListView lvEscuelas;
	public static Activity es;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		es= this;
		setContentView(R.layout.activity_main_por_escuelas);
		
		Typeface miFuente= Typeface.createFromAsset(getAssets(),"fonts/acmesab.TTF");
		TextView txt= (TextView) findViewById(R.id.tituloEscuelas);
		txt.setTypeface(miFuente);
		
		lvEscuelas = (ListView) findViewById(R.id.lvEscuelas);
		new escuelaSearch().execute();
		//Button btnEscueEstadis = new (Button) findViewById(R.id.)
	}
	public void updateListView(ArrayList<Model> escuelas){
		lvEscuelas
		.setAdapter(new ListAdapter(this, R.layout.row_list, escuelas));
	
	}
	class escuelaSearch extends AsyncTask<Object, Void, ArrayList<Model>> {

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
		protected ArrayList<Model> doInBackground(Object... params) {
			ArrayList<Model> escuelas= new ArrayList<Model>();
			
			try {
				for (int i = 0; i < 21; i++) {
					Model escuela= new Model();
					escuela.setNombre("escuela........"+i);
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
		protected void onPostExecute(ArrayList<Model> escuelas) {
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
	

