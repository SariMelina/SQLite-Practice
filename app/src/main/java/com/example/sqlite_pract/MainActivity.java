package com.example.sqlite_pract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtRfc, edtNombre, edtTel, edtCorreo;
    Button btnAgregar, btnEliminar, btnEditar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtRfc = (EditText)findViewById(R.id.editRFC);
        edtNombre = (EditText)findViewById(R.id.editNombre);
        edtTel = (EditText)findViewById(R.id.editTel);
        edtCorreo = (EditText) findViewById(R.id.editCorreo);

        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
    }
}