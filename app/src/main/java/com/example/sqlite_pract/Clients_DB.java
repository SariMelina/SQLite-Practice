package com.example.sqlite_pract;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Clients_DB extends SQLiteOpenHelper {
    private static final String Name_DB = "clients.db";
    private static final int Version_DB = 1;
    private static final String Tabla_Clients = "CREATE TABLE clients(RFC TEXT PRIMARY KEY, " +
            "NOMBRE TEXT," +
            "TELEFONO TEXT," +
            "CORREO TEXT);";

    public Clients_DB(@Nullable Context context) {
        super(context, Name_DB, null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_Clients);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS clients");
        sqLiteDatabase.execSQL(Tabla_Clients);
    }

    public void agregarCliente (String rfc, String nombre, String tele, String correo) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            db.execSQL("INSERT INTO clients VALUES ('"+ rfc +"','"+ nombre +"','"+ tele +"','"+ correo +"')");
            db.close();
        }
    }

    public List<ClientModel> showClients () {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clients", null);
        List<ClientModel> clients = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                clients.add(new ClientModel(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        return clients;
    }

    public void findClient (ClientModel clients, String rfc ) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clients WHERE RFC='"+rfc+"'", null);
        if(cursor.moveToFirst()){
            do {
                clients.setNombre(cursor.getString(1));
                clients.setTel(cursor.getString(2));
                clients.setCorreo(cursor.getString(3));
            }while (cursor.moveToNext());
        }
    }

    public void updateClient (String rfc, String nombre, String tele, String correo) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            db.execSQL("UPDATE clients SET NOMBRE='"+ nombre +"',TELEFONO='"+ tele +"',CORREO='"+ correo +"' WHERE RFC='"+ rfc +"'");
            db.close();
        }
    }

    public void rmClient (String rfc) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            db.execSQL("DELETE FROM clients WHERE RFC='"+ rfc +"'");
            db.close();
        }
    }

}
