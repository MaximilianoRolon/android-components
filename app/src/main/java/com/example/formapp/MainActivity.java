package com.example.formapp;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFecha = findViewById(R.id.tvFecha);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        FragmentManager fragMan = getFragmentManager();
        newFragment.show(fragMan, "datePicker");
    }

    public void sendData(View view) {
        Intent intent = new Intent(this, ConfirmarDatos.class);;
        intent.putExtra("Name", "maxi");
        intent.putExtra("Name", "maxi");
        intent.putExtra("Name", "maxi");
        startActivity(intent);
    }
}


