package com.company;

public class PantallaCrear {
    void mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("CREAR CONTACTO");

        Contacto contacto = new Contacto("Nombre", "1º Apellido", "2º Apellido", "Grupo", "nTelefono", "Email", "Direccion", "Fecha de Cumpleaños");
        CampoDeTexto campoDeTexto = new CampoDeTexto();
        contacto.nombre = campoDeTexto.pedir("Nombre", true);

        contacto.apellido1 = campoDeTexto.pedir("1º Apellido", true);

        contacto.apellido2 = campoDeTexto.pedir("2º Apellido (Opcional)");

        contacto.grupo = campoDeTexto.pedir("Grupo (Familia, Amigos, Trabajos (Opcional)");

        contacto.nTelefono = campoDeTexto.pedir("Numero Telefono", true);

        contacto.eMail = campoDeTexto.pedir("Email (Opcional)");

        contacto.direccion = campoDeTexto.pedir("Direccion (Opcional)");

        contacto.fechaCumpleanyos = campoDeTexto.pedir("Fecha de Cumpleaños (Opcional)");

        BasedeDatos db = BasedeDatos.get();
        db.insertContacto(contacto.nombre, contacto.apellido1, contacto.apellido2, contacto.grupo, contacto.nTelefono, contacto.eMail, contacto.direccion, contacto.fechaCumpleanyos);
        //Main.agenda.contactos.add(contacto);

        Mensaje mensaje = new Mensaje();
        mensaje.mostrarInfo("¡Contacto Guardado Exitosamente!");
    }
}