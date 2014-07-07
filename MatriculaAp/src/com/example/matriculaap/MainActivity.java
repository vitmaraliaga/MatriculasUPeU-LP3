package com.example.matriculaap;




import java.util.ArrayList;

import com.example.list.ListAdapter;
import com.example.model.Model;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//Jhon Ccaypani Vasquez !!

public class MainActivity extends MainBaseMenu {

	private ListView lvPrincipal;
	//private PullToRefreshLayout pull; 
	public static Activity ma;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ma=this;
		setContentView(R.layout.activity_main);
		
		
		
		Typeface miFuente= Typeface.createFromAsset(getAssets(),"fonts/acmesab.TTF");
		TextView txt= (TextView) findViewById(R.id.tituloMain);
		txt.setTypeface(miFuente);
	
		
		
		
		
		lvPrincipal= (ListView) findViewById(R.id.lvPrincipal);
		new principalSearch().execute();
		
	}	
	public void updateListView(ArrayList<Model> principal){
		lvPrincipal.setAdapter(new ListAdapter(this, R.layout.row_list, principal));
		
	} 
	class principalSearch  extends AsyncTask<Object, Void, ArrayList<Model>>{

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			dialog = new ProgressDialog(MainActivity.this);
			dialog.setMessage(getResources().getString(
					R.string.label_tweet_search_loader));
			dialog.show();

		}
		@Override
		protected ArrayList<Model> doInBackground(Object... params) {
			ArrayList<Model> principal= new ArrayList<Model>();
			try {
				for (int i = 0; i < 4; i++) {
					Model princ= new Model();
					princ.setNombre("total matriculados.."+1);
					princ.setCantidad("10"+i);
					princ.setPorcentaje(i+"0%");
					principal.add(princ);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			// TODO Auto-generated method stub
			return principal;
		}
		@Override
		protected void onPostExecute(ArrayList<Model> principal) {
		
			// TODO Auto-generated method stub
			super.onPostExecute(principal);
		dialog.dismiss();
		if(principal.isEmpty()){
			Toast.makeText(MainActivity.this, getResources().getString(R.string.label_tweets_not_found), Toast.LENGTH_SHORT).show();
		} else{
			updateListView(principal);
		}
		
		}
		
		
	}

}
