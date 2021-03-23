package com.company;

public class PantallaMenu {
    boolean mostrar(){
        Titulo titulo = new Titulo();
        titulo.mostrar("AGENDA");

        Menu menu = new Menu();
        String[] opciones = {"LISTAR","AYUDA","SALIR"};
        String opcion = menu.elegirOpcion(opciones);

        if ("1".equals(opcion)) {
            PantallaListar pantallaListar = new PantallaListar();
            pantallaListar.mostrar();
        } else if("2".equals(opcion)){
            PantallaAyuda pantallaAyuda = new PantallaAyuda();
            pantallaAyuda.mostrar();
        } else if ("3".equals(opcion)){
            return false;
        }
        return true;
    }
}
