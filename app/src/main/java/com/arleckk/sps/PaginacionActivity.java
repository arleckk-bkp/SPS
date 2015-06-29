package com.arleckk.sps;

import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class PaginacionActivity extends ActionBarActivity implements View.OnClickListener{

    ListView lista;
    FloatingActionButton fabActualizar;
    ArrayList<Integer> num_paginas,num_marcas;
    ArrayAdapter adaptador;
    int dl,df,desp,marca,tamPagina,numPaginas,aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        this.setSupportActionBar(toolbar);
        this.setTitle(R.string.paginacion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lista = (ListView) findViewById(R.id.lista_paginacion_pag_marco);
        fabActualizar = (FloatingActionButton) findViewById(R.id.fab_actualizar);
        fabActualizar.setOnClickListener(this);
        crearInterfazPaginaMarca();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void crearInterfazPaginaMarca() {
        adaptador = new AdaptadorPaginaMarca(this,crearDatosPaginaMarca());
        lista.setAdapter(adaptador);
    }

    public ArrayList<PaginaMarca> crearDatosPaginaMarca(){
        ArrayList<PaginaMarca> datos = new ArrayList<PaginaMarca>();
        num_marcas = new ArrayList();
        numPaginas = numPaginas();
        tamPagina = tamPaginas();
        for (int i=0;i<=numPaginas;i++){
            datos.add(new PaginaMarca(i,generarMarca()));
        }
        return datos;
    }

    public int generarMarca(){
        Random random = new Random();
        aux = random.nextInt(10);
        if(num_marcas.contains((int)aux)){
            generarMarca();
        } else {
            num_marcas.add(aux);
        }
        return aux;
    }

    public int numPaginas(){
        Random random = new Random();
        return random.nextInt(10);
    }

    public int tamPaginas(){
     Random random = new Random();
        return random.nextInt(8);
    }

    public int tamDirLog(){
        return numPaginas*tamPagina;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab_actualizar:
                crearInterfazPaginaMarca();
                Toast.makeText(getApplicationContext(),R.string.actualizar,Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
