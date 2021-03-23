package com.company;

public class PantallaBuscar {
    boolean mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("BUSCAR CONTACTOS");

        // Aqui es donde hago la busqueda de una persona
        System.out.println("¿A quien buscas?");
        String busqueda = Main.scan.nextLine();
        boolean encontrado = false;
        Contacto contactoEncontrado = null;
        for (Contacto contacto : Main.agenda.contactos){
            if (contacto.nombre.equals(busqueda)){

                System.out.println(contacto.nombre);

                System.out.println(contacto.apellido1);

                if(contacto.apellido2 == null){
                } else{
                    System.out.println(contacto.apellido2);
                }

                if (contacto.grupo == null){
                } else {
                    System.out.println(contacto.grupo);
                }

                System.out.println(contacto.nTelefono);

                if (contacto.eMail == null){
                } else {
                    System.out.println(contacto.eMail);
                }

                if (contacto.fechaCumpleaños == null){
                } else {
                    System.out.println(contacto.fechaCumpleaños);
                }

                System.out.println();

                encontrado = true;
                contactoEncontrado = contacto;
            }
        }
        if (!encontrado) {
            Mensaje mensaje = new Mensaje();
            mensaje.mostrarError("¡Contacto no encontrado!");
        } else {
            Menu menu = new Menu();
            String[] opciones = {"EDITAR", "BORRAR", "SALIR"};
            String opcion = menu.elegirOpcion(opciones);

            if ("1".equals(opcion)) {
                //Editar contacto
                PantallaEditar pantallaEditar = new PantallaEditar();
                pantallaEditar.mostrar(contactoEncontrado);
            } else if ("2".equals(opcion)) {
                //Borrar contacto
                Main.agenda.contactos.remove(contactoEncontrado);
            } else if ("3".equals(opcion)) {
                //Salir
                return false;
            }
        }
        return true;
    }
}