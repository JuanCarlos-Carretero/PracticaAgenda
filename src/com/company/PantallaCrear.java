package com.company;

public class PantallaCrear {
    void mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("CREAR CONTACTO");

        Contacto contacto = new Contacto();

        System.out.println("Nombre de la persona:");
        contacto.nombre = Main.scan.nextLine();

        System.out.println("1º Apellido de la persona:");
        contacto.apellido1 = Main.scan.nextLine();

        System.out.println("2º Apellido de la persona:");
        contacto.apellido2 = Main.scan.nextLine();

        System.out.println("Grupo de la persona (Familia, Amigos, etc):");
        contacto.grupo = Main.scan.nextLine();

        System.out.println("Numero de telefono de la persona:");
        contacto.nTelefono = Main.scan.nextLine();

        System.out.println("Email de la persona:");
        contacto.eMail = Main.scan.nextLine();

        System.out.println("Dirección de la persona:");
        contacto.direccion = Main.scan.nextLine();

        System.out.println("1º Apellido de la persona:");
        contacto.fechaCumpleaños = Main.scan.nextLine();

        Main.agenda.contactos.add(contacto);

        System.out.println("¡Contacto Guardado Exitosamente!");
    }
}
