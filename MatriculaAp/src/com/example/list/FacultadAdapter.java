package com.example.list;

import java.util.ArrayList;
import java.util.List;

import com.example.matriculaap.R;
import com.example.model.Facultad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FacultadAdapter  extends ArrayAdapter<Facultad>{

	private Context context;
	private ArrayList<Facultad> facultades;
	public FacultadAdapter(Context context, int viewResourceId, ArrayList<Facultad> facultades) {
		super(context, viewResourceId,facultades );
		
		this.context= context;
		this.facultades= facultades;
		// TODO Auto-generated constructor stub
	}
	static class ViewHolder{
		public TextView nombreFacultad;
		public TextView cantidad;
		public TextView porcentaje;
		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R
					.layout.row_facultad, parent, false);
			ViewHolder ViewHolder= new ViewHolder();
			ViewHolder.nombreFacultad= (TextView) convertView.findViewById(R.id.txtNombreFacultad);
			ViewHolder.cantidad =(TextView) convertView.findViewById(R.id.txtCantidad);
			ViewHolder.porcentaje=(TextView) convertView.findViewById(R.id.txtPorcentaje);
			convertView.setTag(ViewHolder);
		}
		
		ViewHolder Holder =(ViewHolder) convertView.getTag();
		Holder.nombreFacultad.setText(facultades.get(position).getNombreFacultad());
		Holder.cantidad.setText(facultades.get(position).getCantidad());
		Holder.porcentaje.setText(facultades.get(position).getPorcentaje());
		
		// TODO Auto-generated method stub
		return convertView;
	}

}
