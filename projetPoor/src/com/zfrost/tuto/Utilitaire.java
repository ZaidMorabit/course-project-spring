package com.zfrost.tuto;

public class Utilitaire {

    public static void afficheDesNombre(){
        System.out.println("ca a changé a fou");
        int nombre = 1;
        System.out.println(nombre);
        nombre++;
        System.out.println(nombre);
        nombre++;
        System.out.println(nombre);
        nombre++;
        System.out.println(nombre);
        nombre++;
        System.out.println(nombre);
        nombre++;
        System.out.println(nombre);
    }

    public static int division(int num, int den){
        int resultat = num/den;
        return resultat;
    }

}
