package com.example.list;

import java.util.ArrayList;

import com.example.model.Proceso;


import com.example.matriculaap.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ProcesoAdapter extends ArrayAdapter<Proceso>{
	
	private Context context;
	private ArrayList<Proceso> procesos;
	

	public ProcesoAdapter(Context context, int viewResourceId, 
			ArrayList<Proceso> procesos) {
		super(context, viewResourceId, procesos);
		
		this.context= context;
		this.procesos= procesos;
		// TODO Auto-generated constructor stub
	}
	static class ViewHolder{
		
		public TextView nombre;
		public TextView cantidad;
		public TextView porcentaje;
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	
	if (convertView == null) {

		convertView = LayoutInflater.from(context).inflate(R
				.layout.row_proceso, parent, false);
		ViewHolder ViewHolder = new ViewHolder();
		ViewHolder.nombre= (TextView) convertView.findViewById(R.id.txtNombre);
		ViewHolder.cantidad= (TextView) convertView.findViewById(R.id.txtCantidad);
		ViewHolder.porcentaje= (TextView) convertView.findViewById(R.id.txtPorcentaje);
		convertView.setTag(ViewHolder);	
	}
	ViewHolder Holder =(ViewHolder) convertView.getTag();
	 Holder.nombre.setText(procesos.get(position).getNombre());
	 Holder.cantidad.setText(procesos.get(position).getCantidad());
	 Holder.porcentaje.setText(procesos.get(position).getPorcentaje());
	 
	
	return convertView;
}

}
