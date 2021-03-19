package com.company;

public class PantallaCrear {
    void mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("CREAR CONTACTO");

        Contacto contacto = new Contacto();

        System.out.println("Nombre:");
        contacto.nombre = Main.scan.nextLine();

        System.out.println("1º Apellido:");
        contacto.apellido1 = Main.scan.nextLine();

        System.out.println("2º Apellido:");
        contacto.apellido2 = Main.scan.nextLine();

        System.out.println("Grupo (Familia, Amigos, etc):");
        contacto.grupo = Main.scan.nextLine();

        System.out.println("Telefono:");
        contacto.nTelefono = Main.scan.nextLine();

        System.out.println("Email:");
        contacto.eMail = Main.scan.nextLine();

        System.out.println("Dirección:");
        contacto.direccion = Main.scan.nextLine();

        System.out.println("Fecha de su cumpleaños:");
        contacto.fechaCumpleaños = Main.scan.nextLine();

        Main.agenda.contactos.add(contacto);

        System.out.println("¡Contacto Guardado Exitosamente!");
    }
}
