package com.examen.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nombre;
    public String apellidos;
    public String correo;
    public String contrasena;
}
