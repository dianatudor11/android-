package com.example.didi.monitordidi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button registerMonitorBtn;
    private Button monitorListBtn;
    private Button loadMonitorBtn;
    private Button reportBtn;
    private Button aboutBtn;
    private ArrayList<Monitor> mLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerMonitorBtn = (Button) findViewById(R.id.btnRegisterMonitor);
        monitorListBtn = (Button) findViewById(R.id.btnMonitorList);
        loadMonitorBtn = (Button) findViewById(R.id.btnLoadMonitor);
        reportBtn = (Button) findViewById(R.id.btnReport);
        aboutBtn = (Button) findViewById(R.id.btnAbout);
        mLista = new ArrayList<>();

        registerMonitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerMonitor();
            }
        });
        monitorListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monitorList();
            }
        });
        loadMonitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMonitor();
            }
        });
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                report();
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about();
            }
        });
    }

    private void registerMonitor() {
        Intent intent = new Intent(MainActivity.this, RegisterMonitor.class);
        startActivityForResult(intent, 1);
    }

    private void monitorList() {
        Intent intent = new Intent(MainActivity.this, MonitorList.class);
        startActivity(intent);
    }

    private void loadMonitor() {
        Intent intent = new Intent(MainActivity.this, LoadMonitor.class);
        startActivity(intent);
    }

    private void report() {
        Intent intent = new Intent(MainActivity.this, Report.class);
        startActivity(intent);
    }

    private void about() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("My exam app")
                .setMessage("made by " + getString(R.string.author))
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        alertBuilder.create();
        alertBuilder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Monitor monitor = (Monitor) data.getSerializableExtra(getString(R.string.single_monitor));
        mLista.add(monitor);
    }
}
