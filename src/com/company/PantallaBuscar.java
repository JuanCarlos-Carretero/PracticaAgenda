package com.company;

import static com.company.Main.*;

public class PantallaBuscar {
    boolean mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("BUSCAR CONTACTOS");

        // Aqui es donde hago la busqueda de una persona
        System.out.println("¿A quien buscas?");
        String busquedaContacto = scan.next();

        for (Contacto contacto : Main.db.ContactoEncontrado(busquedaContacto)) {
                // System.out.println(contacto.nombre);
                System.out.println("Nombre: " + contacto.nombre);

                // System.out.println(contacto.apellido1);
                System.out.println("1º Apellido: " + contacto.apellido1);

                if (contacto.apellido2 == null || contacto.apellido2.equals("")) {

                } else {
                    System.out.println("2º Apellido: " + contacto.apellido2);
                }

                if (contacto.grupo == null || contacto.grupo.equals("")) {

                } else {
                    System.out.println("Grupo: " + contacto.grupo);
                }

                // System.out.println(contacto.nTelefono);
                System.out.println("Numero de Telefono: " + contacto.nTelefono);

                if (contacto.eMail == null || contacto.eMail.equals("")) {

                } else {
                    System.out.println("Email: " + contacto.eMail);
                }

                if (contacto.fechaCumpleanyos == null || contacto.fechaCumpleanyos.equals("")) {

                } else {
                    System.out.println(contacto.fechaCumpleanyos);
                }
                Menu menu = new Menu();
                String[] opciones = {"EDITAR", "BORRAR", "SALIR"};
                String opcion = menu.elegirOpcion(opciones);

                if ("1".equals(opcion)) {
                    //Editar contacto
                    PantallaEditar pantallaEditar = new PantallaEditar();
                    pantallaEditar.mostrar(contacto);
                } else if ("2".equals(opcion)) {
                    //Borrar contacto
                    db.deleteContacto(contacto);
                    Mensaje mensaje = new Mensaje();
                    mensaje.mostrarInfo("¡El contacto se ha borrado satisfactoriamente!");
                } else if ("3".equals(opcion)) {
                    //Salir
                    return false;
                }
            }
        return true;
    }
}