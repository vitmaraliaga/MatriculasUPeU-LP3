package com.example.list;

import java.util.ArrayList;

import com.example.model.Escuela;


import com.example.matriculaap.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EscuelaAdapter extends ArrayAdapter<Escuela>{

	
	private Context context;
	private ArrayList<Escuela> escuelas;
	
	public EscuelaAdapter(Context context, int viewResourceId, 
			ArrayList<Escuela> escuelas) {
		super(context, viewResourceId, escuelas);
		// TODO Auto-generated constructor stub

		this.context=context;
		this.escuelas= escuelas;
		
		// TODO Auto-generated constructor stub
	}
	static class ViewHolder{
		public TextView nombreEscuela;
		public TextView cantidad;
		public TextView porcentaje;
		
		
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
if(convertView == null){
	
	convertView = LayoutInflater.from(context).inflate(R
			.layout.row_escuela, parent, false);
	ViewHolder ViewHolder= new ViewHolder();
	ViewHolder.nombreEscuela= (TextView) convertView.findViewById(R.id.txtNombre);
	ViewHolder.cantidad= (TextView) convertView.findViewById(R.id.txtCantidad);
	ViewHolder.porcentaje=  (TextView) convertView.findViewById(R.id.txtPorcentaje);
    convertView.setTag(ViewHolder);
}
ViewHolder Holder = (ViewHolder) convertView.getTag();
Holder.nombreEscuela.setText(escuelas.get(position).getNombreEscuela());
Holder.cantidad.setText(escuelas.get(position).getCantidad());
Holder.porcentaje.setText(escuelas.get(position).getPorcentaje());


	
	
	// TODO Auto-generated method stub
	return convertView;
}
	

}
