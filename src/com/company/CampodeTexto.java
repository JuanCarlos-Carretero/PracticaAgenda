package com.company;

class CampoDeTexto {
    String pedir(String prompt) {
        return pedir(prompt, false);
    }

    String pedir(String prompt, boolean obligatiorio){
        System.out.println("\033[35m" + prompt + ":\033[0m");
        if(!obligatiorio){
            return Main.scan.nextLine();
        } else {

            while(true){
                String texto = Main.scan.nextLine();

                if(!texto.isEmpty()){
                    return texto;
                } else {
                    Mensaje mensaje = new Mensaje();
                    mensaje.mostrarWarn("!Introduzca el campo!");
                }
            }
        }
    }
}