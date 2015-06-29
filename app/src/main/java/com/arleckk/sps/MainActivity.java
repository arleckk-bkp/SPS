package com.arleckk.sps;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    Button btn_paginacion, btn_segmentacion, btn_pag_seg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        this.setSupportActionBar(toolbar);
        btn_paginacion = (Button) findViewById(R.id.btn_paginacion);
        btn_paginacion.setOnClickListener(this);
        btn_segmentacion = (Button) findViewById(R.id.btn_segmentacion);
        btn_segmentacion.setOnClickListener(this);
        btn_pag_seg = (Button) findViewById(R.id.btn_pag_seg);
        btn_pag_seg.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_paginacion:
                Intent intent = new Intent (this,PaginacionActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_segmentacion:
                intent = new Intent (this,SegmentacionActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_pag_seg:
                intent = new Intent (this,PagSegActivity.class);
                startActivity(intent);
                break;
        }//switch
    }
}
