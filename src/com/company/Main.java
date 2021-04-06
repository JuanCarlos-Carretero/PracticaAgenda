package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Agenda agenda = new Agenda();
    public static void main(String[] args) {
        BasedeDatos db = BasedeDatos.get();
        PantallaMenu pantallaMenu = new PantallaMenu();
        while(pantallaMenu.mostrar()) { }
    }
}