package org.example.utils;

import sun.lwawt.macosx.CSystemTray;

public class StringUtils {
    public static void main(String[] args) {
        System.out.print(repeat("hola", 4));

    }

    public static String repeat(String cadena, int cantidad){
        if(cantidad<0){
            throw new IllegalArgumentException("Negative times no allowed");
        }
        String nuevo = "";
        for(int x=0; x<cantidad; x++){
            nuevo=nuevo+cadena;
        }
        return nuevo;
    }

    public static Boolean isEmpty(String cadena){
        return cadena == null || cadena.trim().length() == 0;
    }
}
