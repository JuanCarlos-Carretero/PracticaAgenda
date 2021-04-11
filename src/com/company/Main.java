package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static BasedeDatos db = BasedeDatos.get();

    public static void main(String[] args) {
        PantallaMenu pantallaMenu = new PantallaMenu();
        while(pantallaMenu.mostrar()) { }
    }
}