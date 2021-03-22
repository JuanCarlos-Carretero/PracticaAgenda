package com.company;

public class PantallaEditar {
    void mostrar(Contacto contacto) {
        Titulo titulo = new Titulo();
        titulo.mostrar("EDITAR CONTACTO");

        CampoDeTexto campoDeTexto = new CampoDeTexto();

        System.out.println("Nombre: "+ contacto.nombre);
        contacto.nombre = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        System.out.println("1º Apellido: "+ contacto.apellido1);
        contacto.apellido1 = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        System.out.println("2º Apellido: "+ contacto.apellido2);
        contacto.apellido2 = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        System.out.println("Grupo(Familia, Amigos, etc): "+ contacto.grupo);
        contacto.grupo = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        System.out.println("Telefono: "+ contacto.nTelefono);
        contacto.nTelefono = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        System.out.println("Email: "+ contacto.eMail);
        contacto.eMail = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        System.out.println("Dirección: "+ contacto.direccion);
        contacto.direccion = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        System.out.println("Fecha de su cumpleaños: "+ contacto.fechaCumpleaños);
        contacto.fechaCumpleaños = campoDeTexto.pedir("¿Por cual quieres cambiar?");

        Mensaje mensaje = new Mensaje();
        mensaje.mostrarInfo("¡Contacto Editado Exitosamente!");
    }
}
