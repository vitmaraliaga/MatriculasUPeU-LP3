package com.example.matriculaap;

import java.util.ArrayList;


import com.example.list.ListAdapter;
import com.example.model.Model;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainPorFacultades extends MainBaseMenu  {

	private ListView lvFacultades;
	public static Activity fa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fa=this;
		setContentView(R.layout.activity_main_por_facultades);
		
		Typeface miFuente= Typeface.createFromAsset(getAssets(),"fonts/acmesab.TTF");
		TextView txt= (TextView) findViewById(R.id.tituloFacultades);
		txt.setTypeface(miFuente);
		
		lvFacultades=(ListView) findViewById(R.id.lvFacultades);
		//Button btnFaculEstadis = (Button) findViewById(R.id.btnFaculEstadis);
	   new facultadSearch().execute();
	
	}
public void updateListView(ArrayList<Model> facultades){
	lvFacultades
	.setAdapter(new ListAdapter(this, R.layout.row_list, facultades));
	
}
	
class facultadSearch extends AsyncTask<Object, Void, ArrayList<Model>> {

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
	protected ArrayList<Model> doInBackground(Object... params) {
		ArrayList<Model> facultades= new ArrayList<Model>();
		try {
			for (int i = 0; i < 4; i++) {
				Model facultad= new Model();
				facultad.setNombre("FACULTAD---"+i);
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
	protected void onPostExecute(ArrayList<Model> facultades) {
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
