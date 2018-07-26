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
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Bundle datos;
    EditText tvFecha;
    EditText etNombre;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcionContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFecha = findViewById(R.id.tvFecha);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcionContacto = findViewById(R.id.etDescripcionContacto);
        etNombre = findViewById(R.id.etNombre);

        // SETEO INICIAL OPCIONAL DE DATOS
        Intent intent = this.getIntent();

        if (intent.getExtras() != null){
            Bundle datos = intent.getExtras();
            if (datos.getString("FECHA") != null ){
                tvFecha.setText(datos.getString("FECHA"));
            }
            if (datos.getString("TELEFONO") != null ){
                etTelefono.setText(datos.getString("TELEFONO"));
            }
            if (datos.getString("EMAIL") != null ){
                etEmail.setText(datos.getString("EMAIL"));
            }
            if (datos.getString("DESCRIPCION") != null ){
                etDescripcionContacto.setText(datos.getString("DESCRIPCION"));
            }
            if (datos.getString("NOMBRE") != null ){
                etNombre.setText(datos.getString("NOMBRE"));
            }
        }


    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        FragmentManager fragMan = getFragmentManager();
        newFragment.show(fragMan, "datePicker");
    }

    public void sendData(View view) {

        String fecha_text = tvFecha.getText().toString();
        String telefono_text = etTelefono.getText().toString();
        String descripcion_text = etDescripcionContacto.getText().toString();
        String email_text = etEmail.getText().toString();
        String nombre_text = etNombre.getText().toString();

        if ((fecha_text.equals(getString(R.string.text_fecha))) || (telefono_text.equals("")) || (descripcion_text.equals("")) || (email_text.equals("")) || (nombre_text.equals(""))) {
        } else {

            Intent intent = new Intent(this, ConfirmarDatos.class);
            intent.putExtra("FECHA", tvFecha.getText().toString());
            intent.putExtra("NOMBRE", etNombre.getText().toString());
            intent.putExtra("TELEFONO", etTelefono.getText().toString());
            intent.putExtra("EMAIL", etEmail.getText().toString());
            intent.putExtra("DESCRIPCION", etDescripcionContacto.getText().toString());
            startActivity(intent);

        }
    }
}


