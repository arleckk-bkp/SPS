package com.arleckk.sps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by arleckk on 28/06/2015.
 */
public class AdaptadorPaginaMarca extends ArrayAdapter<PaginaMarca> {

    public AdaptadorPaginaMarca (Context context,ArrayList<PaginaMarca> objects){
        super(context,0,objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView = convertView;
        if(null == convertView){
            listItemView = inflater.inflate(R.layout.lista_pagina_marco,parent,false);
        }
        TextView text_num_pagina = (TextView)listItemView.findViewById(R.id.text_num_pagina);
        TextView text_num_marca = (TextView)listItemView.findViewById(R.id.text_num_marca);

        PaginaMarca item = getItem(position);
        text_num_pagina.setText(String.valueOf(item.getPagina()));
        text_num_marca.setText(String.valueOf(item.getMarca()));

        return listItemView;
    }

}
