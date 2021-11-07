package com.example.sqlite_pract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tabla_Clients);
        sqLiteDatabase.execSQL(Tabla_Clients);
    }

    public void agregarCliente (String rfc, String nombre, String tele, String correo) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            db.execSQL("INSERT INTO clients VALUES ('"+ rfc +"','"+ nombre +"','"+ tele +"','"+ correo +"')");
            db.close();
        }
    }
}
