package com.company;

public class PantallaBuscar {
    boolean mostrar() {
        Titulo titulo = new Titulo();
        titulo.mostrar("BUSCAR CONTACTOS");

        Menu menu = new Menu();
        String[] opciones = {"EDITAR", "BORRAR", "SALIR"};
        String opcion = menu.elegirOpcion(opciones);

        if ("1".equals(opcion)) {
            PantallaEditar pantallaEditar = new PantallaEditar();
            pantallaEditar.mostrar();
        } else if("2".equals(opcion)){

        } else if("3".equals(opcion)){
            return false;
        }
        return true;
    }
}
