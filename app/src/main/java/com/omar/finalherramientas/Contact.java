package com.omar.finalherramientas;

import android.net.Uri;
/**
 * Created by Cristian on 12/11/2017.
 */
public class Contact {

    private String _nombre, _telefono, _email, _direccion, _cedula, _tipo;
    private Uri _imageURI;
    private int _id;

    public Contact (int id, String nombre, String telefono, String email, String direccion, Uri imageURI, String cedula, String tipo) {
        _id = id;
        _nombre = nombre;
        _telefono = telefono;
        _email = email;
        _direccion = direccion;
        _imageURI = imageURI;
        _cedula = cedula;
        _tipo = tipo;

    }

    public int getId() { return _id; }

    public String getNombre() {
        return _nombre;
    }

    public String getTelefono() {
        return _telefono;
    }

    public String getEmail() {
        return _email;
    }

    public String getDireccion() {
        return _direccion;
    }

    public Uri getImageURI() { return _imageURI; }

    public String getCedula() {
        return _cedula;
    }

    public String getTipo() {
        return _tipo;
    }
}
