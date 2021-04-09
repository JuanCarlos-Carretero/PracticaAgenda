package com.company;

public class PantallaAyuda {
    boolean mostrar(){
        Titulo titulo = new Titulo();
        titulo.mostrar("AYUDA");

        Mensaje mensaje = new Mensaje();

        System.out.println("Bienvenidos a la pantalla de ayuda:");
        System.out.println("Pongan atencion a los colores:");
        System.out.println("\033[31m"+"- El color rojo = Error"+"\033[0m");
        System.out.println("\033[33m"+"- El color amarillo = Advertencia"+"\033[0m");
        System.out.println("\033[36m"+"- El color cyan = Informacion"+"\033[0m");
        System.out.println("\033[35m"+"- El color morado = Campos a rellenar"+"\033[0m");
        System.out.println();
        System.out.println("Para borrar un contacto vaya a la opcion: 1, 1, (buscas el nombre del contacto) y 2 ");
        System.out.println("Para borrar un campo no obligatorio vaya a la opcion: 1, 1, (buscas el nombre del contacto) y 1");
        System.out.println("y despues escriba: - (Cuando este sobre el campo que quiera dejar en blanco)");
        System.out.println();

        Menu menu = new Menu();
        String[] opciones = {"Buscar Contacto", "Crear contacto", "Salir"};
        String opcion = menu.elegirOpcion(opciones);

        if ("1".equals(opcion)) {
            PantallaBuscar pantallaBuscar = new PantallaBuscar();
            pantallaBuscar.mostrar();
        } else if ("2".equals(opcion)){
            PantallaCrear pantallaCrear = new PantallaCrear();
            pantallaCrear.mostrar();
        } else if ("3".equals(opcion)){
            return false;
        }
        return true;
    }
}
