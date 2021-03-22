package com.company;

public class PantallaCrear {
    void mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("CREAR CONTACTO");

        Contacto contacto = new Contacto();
        CampoDeTexto campoDeTexto = new CampoDeTexto();

        contacto.nombre = campoDeTexto.pedir("Nombre", true);

        contacto.apellido1 = campoDeTexto.pedir("1º Apellido", true);

        contacto.apellido2 = campoDeTexto.pedir("2º Apellido");

        contacto.grupo = campoDeTexto.pedir("Grupo (Familia, Amigos, Trabajos");

        contacto.nTelefono = campoDeTexto.pedir("Numero Telefono");

        contacto.eMail = campoDeTexto.pedir("Email");

        contacto.direccion = campoDeTexto.pedir("Direccion");

        contacto.fechaCumpleaños = campoDeTexto.pedir("Fecha de Cumpleaños");

        Main.agenda.contactos.add(contacto);

        System.out.println("¡Contacto Guardado Exitosamente!");
    }
}
