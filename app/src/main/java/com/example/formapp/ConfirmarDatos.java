package com.example.formapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    Bundle datos;
    String fecha;
    String nombre;
    String telefono;
    String email;
    String descripcion;
    TextView tvFechaEdit;
    TextView tvNombreEdit;
    TextView tvTelefonoEdit;
    TextView tvEmailEdit;
    TextView tvDescripcionContactoEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        datos = this.getIntent().getExtras();

        // EXTRA DE INTENTS
        fecha = datos.getString("FECHA");
        nombre = datos.getString("NOMBRE");
        telefono = datos.getString("TELEFONO");
        email = datos.getString("EMAIL");
        descripcion = datos.getString("DESCRIPCION");

        // COMPONENTES Y SETEADO DE LOS MISMOS
        tvFechaEdit = findViewById(R.id.tvFechaEdit);
        tvFechaEdit.setText(fecha);
        tvTelefonoEdit = findViewById(R.id.tvTelefonoEdit);
        tvTelefonoEdit.setText(telefono);
        tvEmailEdit = findViewById(R.id.tvEmailEdit);
        tvEmailEdit.setText(email);
        tvDescripcionContactoEdit = findViewById(R.id.tvDescripcionContactoEdit);
        tvDescripcionContactoEdit.setText(descripcion);
        tvNombreEdit = findViewById(R.id.tvNombreEdit);
        tvNombreEdit.setText(nombre);
    }

    public void clickEditData(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("FECHA", tvFechaEdit.getText().toString());
        intent.putExtra("NOMBRE", tvNombreEdit.getText().toString());
        intent.putExtra("TELEFONO", tvTelefonoEdit.getText().toString());
        intent.putExtra("EMAIL", tvEmailEdit.getText().toString());
        intent.putExtra("DESCRIPCION", tvDescripcionContactoEdit.getText().toString());
        startActivity(intent);
    }


}
