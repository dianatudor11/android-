package com.example.didi.monitordidi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MonitorList extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter customAdapter;
    private ArrayList<Monitor> mLista;

    private int positionGot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_list);

        mLista = new ArrayList<>();
        Intent intent = getIntent();
        mLista = (ArrayList<Monitor>) intent.getSerializableExtra("lista_monitoare");

        listView = (ListView) findViewById(R.id.listView);
        customAdapter = new CustomAdapter(MonitorList.this, mLista);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,int i, long l) {
                positionGot = i;
                modificaMonitor(positionGot);
            }
        });

    }
    private void modificaMonitor(int positionGot){
        Intent intent = new Intent(MonitorList.this, RegisterMonitor.class);
        intent.putExtra(getString(R.string.este_editabil),"edit");
        intent.putExtra(getString(R.string.monitor_de_editat), mLista.get(positionGot));

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent ){
        super.onActivityResult(requestCode, resultCode, intent);
        Monitor monitor = (Monitor) intent.getSerializableExtra(getString(R.string.single_monitor));

        mLista.set(positionGot,monitor);
        customAdapter.notifyDataSetChanged();
    }
}
