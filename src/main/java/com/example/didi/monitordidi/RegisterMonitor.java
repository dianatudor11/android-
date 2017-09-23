package com.example.didi.monitordidi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Date;

public class RegisterMonitor extends AppCompatActivity {

    private EditText serviceNumberEditText;
    private EditText producerEditText;
    private SeekBar seekBar;
    private EditText ownerEditText;
    private DatePicker datePicker;
    private Button saveBtn;
    private int Progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_monitor);

        serviceNumberEditText = (EditText) findViewById(R.id.serviceNumberEditText);
        producerEditText = (EditText) findViewById(R.id.producerEditText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ownerEditText = (EditText) findViewById(R.id.ownerEditText);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        saveBtn = (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        //validari
        Intent intent = getIntent();
        String este_editabil = (String)intent.getStringExtra(getString(R.string.este_editabil));
        if(este_editabil != null)
            if (este_editabil.equals("edit")) {
                Monitor monitor = (Monitor) intent.getSerializableExtra(getString(R.string.monitor_de_editat));
                insereazaValorileInCampuri(monitor);
            }

    }

    private void insereazaValorileInCampuri(Monitor monitor){
        serviceNumberEditText.setText(Integer.toString(monitor.getServiceNumber()));
        producerEditText.setText(monitor.getProducer());
        seekBar.setProgress(monitor.getDiagonal());
        ownerEditText.setText(monitor.getOwner());
        datePicker.updateDate(monitor.getServiceDate().getYear()-1900,monitor.getServiceDate().getMonth(),monitor.getServiceDate().getDay());
    }

    private void save(){
        if(serviceNumberEditText.getText().toString().isEmpty() || producerEditText.getText().toString().isEmpty()
                || ownerEditText.getText().toString().isEmpty()){
            Toast.makeText(RegisterMonitor.this, "fill out all the fields", Toast.LENGTH_SHORT).show();
        }else {
            int a = Integer.parseInt(serviceNumberEditText.getText().toString());
            String b = producerEditText.getText().toString();

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            String d = ownerEditText.getText().toString();
            Date e = new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
            Progress = seekBar.getProgress() + 14;
            Monitor monitor = new Monitor(a, b, Progress, d , e);

            Intent intent = new Intent();
            intent.putExtra(getString(R.string.single_monitor), monitor);
            setResult(RESULT_OK, intent);
            finish();

            Toast.makeText(RegisterMonitor.this, "Monitor inserted " + monitor.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
