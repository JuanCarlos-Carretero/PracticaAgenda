package com.company;

public class PantallaListar {
    boolean mostrar(){
        Titulo titulo = new Titulo();
        titulo.mostrar("LISTA CONTACTOS");

        //Aqui te dice los nombres de los contactos
        for(Contacto contacto: Main.agenda.contactos){
            System.out.println(contacto.nombre);
        }
        System.out.println();

        Menu menu = new Menu();
        String[] opciones = {"BUSCAR", "CREAR"};
        String opcion = menu.elegirOpcion(opciones);

        if ("1".equals(opcion)) {
            PantallaBuscar pantallaBuscar = new PantallaBuscar();
            pantallaBuscar.mostrar();
        } else if("2".equals(opcion)){
            PantallaCrear pantallaCrear = new PantallaCrear();
            pantallaCrear.mostrar();
        }
        return true;
    }

}
