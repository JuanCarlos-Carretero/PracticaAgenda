package com.company;

public class Contacto {
    String nombre;
    String apellido1;
    String apellido2;
    String grupo;
    String nTelefono;
    String eMail;
    String direccion;
    String fechaCumpleanyos;

    public Contacto(String nombre, String apellido1, String apellido2, String grupo, String nTelefono, String eMail, String direccion, String fechaCumpleanyos) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.grupo = grupo;
        this.nTelefono = nTelefono;
        this.eMail = eMail;
        this.direccion = direccion;
        this.fechaCumpleanyos = fechaCumpleanyos;
    }
}
