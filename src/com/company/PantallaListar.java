package com.company;

import java.util.List;

public class PantallaListar {
    boolean mostrar(){
        BasedeDatos.createTables();
        Titulo titulo = new Titulo();
        titulo.mostrar("LISTA CONTACTOS");
        //Aqui te dice los nombres de los contactos
        List<Contacto> listacontactos = Main.db.listaContacto();
        //Aqui te busca si hay o no contactos en la base de datos
        if (listacontactos.size() == 0){
            Mensaje mensaje = new Mensaje();
            mensaje.mostrarWarn("No hay contactos guardados");
        } else {
            int i = 1;
            for(Contacto contacto: Main.db.listaContacto()){
                System.out.println(i + "- " + contacto.nombre);
                i++;
            }
            System.out.println();
        }
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
