package com.company;

public class PantallaEditar {
    void mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("EDITAR CONTACTO");

        Contacto contacto = new Contacto();

        System.out.println("Nombre de la persona: "+ contacto.nombre);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.nombre = Main.scan.nextLine();

        System.out.println("1º Apellido de la persona: "+ contacto.apellido1);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.apellido1 = Main.scan.nextLine();

        System.out.println("2º Apellido de la persona: "+ contacto.apellido2);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.apellido2 = Main.scan.nextLine();

        System.out.println("Grupo de la persona (Familia, Amigos, etc): "+ contacto.grupo);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.grupo = Main.scan.nextLine();

        System.out.println("Numero de telefono de la persona: "+ contacto.nTelefono);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.nTelefono = Main.scan.nextLine();

        System.out.println("Email de la persona: "+ contacto.eMail);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.eMail = Main.scan.nextLine();

        System.out.println("Dirección de la persona: "+ contacto.direccion);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.direccion = Main.scan.nextLine();

        System.out.println("1º Apellido de la persona: "+ contacto.fechaCumpleaños);
        System.out.println("¿Por cual quieres cambiar?");
        contacto.fechaCumpleaños = Main.scan.nextLine();

        Main.agenda.contactos.add(contacto);

        System.out.println("¡Contacto Editado Exitosamente!");
    }
}
