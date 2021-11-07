package com.example.sqlite_pract;

import android.widget.EditText;

public class ClientModel {
    private String rfc, nombre, tel, correo;

    public ClientModel() {
    }

    public ClientModel(String rfc, String nombre, String tel, String correo) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.tel = tel;
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
