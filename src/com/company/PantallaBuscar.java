package com.company;

public class PantallaBuscar {
    boolean mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("BUSCAR CONTACTOS");
        System.out.println("¿A quien buscas?");

        // Aqui es donde hago la busqueda de una persona
        String busqueda = Main.scan.next();
        for (int i = 0; i < Main.agenda.contactos.toArray().length; i++) {
            if (Main.agenda.contactos.toArray().equals(busqueda)) {
                System.out.println(Main.agenda.contactos);
            } else {
                Mensaje mensaje = new Mensaje();
                mensaje.mostrarError("Ese contacto no existe");

            }

            Menu menu = new Menu();
            String[] opciones = {"EDITAR", "BORRAR", "SALIR"};
            String opcion = menu.elegirOpcion(opciones);

            if ("1".equals(opcion)) {
                PantallaEditar pantallaEditar = new PantallaEditar();
                pantallaEditar.mostrar();
            } else if ("2".equals(opcion)) {

            } else if ("3".equals(opcion)) {
                return false;
            }
        }
        return true;
    }
}
