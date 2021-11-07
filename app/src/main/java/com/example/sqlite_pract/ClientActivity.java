package com.example.sqlite_pract;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity {

    private RecyclerView recyclerViewClient ;
    private ClientAdapter clientAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_layout);

        recyclerViewClient = (RecyclerView) findViewById(R.id.recyclerClient);
        recyclerViewClient.setLayoutManager(new LinearLayoutManager(this));

        Clients_DB clients_db = new Clients_DB(getApplicationContext());


        clientAdapter = new ClientAdapter (clients_db.showClients());
        recyclerViewClient.setAdapter(clientAdapter);
    }
}
