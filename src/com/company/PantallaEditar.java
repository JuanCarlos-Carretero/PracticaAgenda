package com.company;

public class PantallaEditar {
    void mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("EDITAR CONTACTO");

        Contacto contacto = new Contacto();

        System.out.println("Nombre: "+ contacto.nombre);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.nombre = Main.scan.nextLine();

        System.out.println("1º Apellido: "+ contacto.apellido1);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.apellido1 = Main.scan.nextLine();

        System.out.println("2º Apellido: "+ contacto.apellido2);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.apellido2 = Main.scan.nextLine();

        System.out.println("Grupo(Familia, Amigos, etc): "+ contacto.grupo);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.grupo = Main.scan.nextLine();

        System.out.println("Numero de telefono: "+ contacto.nTelefono);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.nTelefono = Main.scan.nextLine();

        System.out.println("Email: "+ contacto.eMail);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.eMail = Main.scan.nextLine();

        System.out.println("Dirección: "+ contacto.direccion);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.direccion = Main.scan.nextLine();

        System.out.println("Fecha de su cumpleaños: "+ contacto.fechaCumpleaños);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.fechaCumpleaños = Main.scan.nextLine();

        Main.agenda.contactos.add(contacto);

        System.out.println("¡Contacto Editado Exitosamente!");
    }
}
