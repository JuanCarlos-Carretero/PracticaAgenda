package com.company;

public class PantallaEditar {
    void mostrar(Contacto contacto) {
        Titulo titulo = new Titulo();
        titulo.mostrar("EDITAR CONTACTO");

        CampoDeTexto campoDeTexto = new CampoDeTexto();
        Mensaje mensaje = new Mensaje();

        //Esto permite editar el nombre sin problemas
        System.out.println("Nombre: "+ contacto.nombre);
        String nuevoNombre = campoDeTexto.pedir("¿Por cual quieres cambiar?",true);
        if (!nuevoNombre.isEmpty()){ //Si el nombre introducido no es null se cambia por el nuevo nombre
            contacto.nombre = nuevoNombre;
        }

        //Esto permite editar el apellido1 sin problemas
        System.out.println("1º Apellido: "+ contacto.apellido1);
        String nuevoApellido1 = campoDeTexto.pedir("¿Por cual quieres cambiar?", true);
        if (!nuevoNombre.isEmpty()){ //Si el apellido1 introducido no es null se cambia por el nuevo nombre
            contacto.apellido1 = nuevoApellido1;
        }

        //Esto permite editar el apellido2 sin problemas
        System.out.println("2º Apellido: "+ contacto.apellido2);
        String nuevoApellido2 = campoDeTexto.pedir("¿Por cual quieres cambiar?");
        if (nuevoNombre.equals("-")){ //Esto permite borrar el apellido2 en caso de que se quiera borrar
            contacto.apellido2 = null;
        } else if (!nuevoNombre.isEmpty()){ //Si el apellido2 introducido no es null se cambia por el nuevo nombre
            contacto.apellido2 = nuevoApellido2;
        }

        //Esto permite editar el grupo sin problemas
        System.out.println("Grupo(Familia, Amigos, etc): "+ contacto.grupo);
        String nuevoGrupo = campoDeTexto.pedir("¿Por cual quieres cambiar?");
        if (nuevoNombre.equals("-")){ //Esto permite borrar el grupo en caso de que se quiera borrar
            contacto.grupo = null;
        } else if (!nuevoNombre.isEmpty()){ //Si el grupo introducido no es null se cambia por el nuevo nombre
            contacto.grupo = nuevoGrupo;
        }

        //Esto permite editar el telefono sin problemas
        System.out.println("Telefono: "+ contacto.nTelefono);
        String nuevoTelefono = campoDeTexto.pedir("¿Por cual quieres cambiar?",true);
        if (!nuevoNombre.isEmpty()){ //Si el telefono introducido no es null se cambia por el nuevo nombre
            contacto.nTelefono = nuevoTelefono;
        }

        //Esto permite editar el Email sin problemas
        System.out.println("Email: "+ contacto.eMail);
        String nuevoEmail = campoDeTexto.pedir("¿Por cual quieres cambiar?");
        if (nuevoNombre.equals("-")){ //Esto permite borrar el email en caso de que se quiera borrar
            contacto.eMail = null;
        } else if (!nuevoNombre.isEmpty()){ //Si el email introducido no es null se cambia por el nuevo nombre
            contacto.eMail = nuevoEmail;
        }

        //Esto permite editar la direccion sin problemas
        System.out.println("Dirección: "+ contacto.direccion);
        String nuevaDireccion = campoDeTexto.pedir("¿Por cual quieres cambiar?");
        if (nuevoNombre.equals("-")){ //Esto permite borrar la direccion en caso de que se quiera borrar
            contacto.direccion = null;
        } else if (!nuevoNombre.isEmpty()){ //Si la direccion introducido no es null se cambia por el nuevo nombre
            contacto.direccion = nuevaDireccion;
        }

        //Esto permite borrar la fecha de cumpleaños sin problema
        System.out.println("Fecha de su cumpleaños: "+ contacto.fechaCumpleaños);
        String nuevoFechaCumpleaños = campoDeTexto.pedir("¿Por cual quieres cambiar?");
        if (nuevoNombre.equals("-")){ //Esto permite borrar la fecha en caso de que se quiera borrar
            contacto.fechaCumpleaños = null;
        } else if (!nuevoNombre.isEmpty()){ //Si la fecha introducido no es null se cambia por el nuevo nombre
            contacto.fechaCumpleaños = nuevoFechaCumpleaños;
        }


        mensaje.mostrarInfo("¡Contacto Editado Exitosamente!");
    }
}
