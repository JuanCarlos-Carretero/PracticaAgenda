package com.company;

public class PantallaAyuda {
    boolean mostrar(){
        Titulo titulo = new Titulo();
        titulo.mostrar("AYUDA");

        System.out.println("Bienvenidos a la pantalla de ayuda:");
        System.out.println("Pongan atencion a los colores:");
        System.out.println("- El color rojo = Error");
        System.out.println("- El color amarillo = Advertencia");
        System.out.println("- El color cyan = Informacion");
        System.out.println("- El color morado = Campos a rellenar");
        System.out.println();
        System.out.println("Para borrar un contacto vaya a la opcion: 1, 1, (buscas el nombre del contacto) y 2 ");
        System.out.println("Para borrar un campo no obligatorio vaya a la opcion: 1, 1, (buscas el nombre del contacto) y 1");
        System.out.println("y despues escriba: - (Cuando este sobre el campo que quiera dejar en blanco)");
        System.out.println();

        Menu menu = new Menu();
        String[] opciones = {"Buscar Contacto", "Crear contacto"};
        String opcion = menu.elegirOpcion(opciones);

        if ("1".equals(opcion)) {
            PantallaMenu pantallaMenu = new PantallaMenu();
            pantallaMenu.mostrar();
        } else if ("2".equals(opcion)){
            return false;
        }
        return true;
    }
}
