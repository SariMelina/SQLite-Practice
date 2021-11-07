package com.example.sqlite_pract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

        final Clients_DB clientDB = new Clients_DB(getApplicationContext()) ;
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clientDB.agregarCliente(edtRfc.getText().toString(),
                        edtNombre.getText().toString(),
                        edtTel.getText().toString(),
                        edtCorreo.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGÓ UN NUEVO CLIENTE",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showClients = new Intent(getApplicationContext(), ClientActivity.class);
                startActivity(showClients);
            }
        });

    }
}