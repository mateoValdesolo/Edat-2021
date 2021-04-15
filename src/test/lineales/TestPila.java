/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.estaticas.Pila;

/**
 *
 * @author mateo
 */
public class TestPila {

    public static void main(String[] args) {
        Pila pil1 = new Pila();
        Pila pil2 = new Pila();

        //Para int
        int cont = 0;

        pil1.apilar(1);
        pil1.apilar(2);
        pil1.apilar(1);
        
        /*for (int i = 1; i <= 20; i++) {
            pil1.apilar(i);
        }
        /*System.out.println(pil1.toString());
        System.out.println(pil2.toString());
        pil2 = pil1.clone();
        System.out.println(pil2.toString());
        pil2.desapilar();
        System.out.println(pil2.toString());
        System.out.println(pil2.obtenerTope());
        pil2.vaciar();
        System.out.println(pil2.toString());
        System.out.println(pil2.esVacia());*/

        /*for (int i = 0; i <= pil1.toString().length(); i++) {
            if (pil1.toString().charAt(i) != ' '){
                cont++;
            }
        }*/
        pil1.vaciar();
        System.out.println(pil1.esVacia());
        System.out.println(pil1.toString());
        System.out.println(verifCapicua(pil1));
    }

    public static boolean verifCapicua(Pila pil) {
        boolean verif = false;   
        Pila pil2 = new Pila();
        Pila pil3 = new Pila();
        pil3 = pil.clone();
        while (pil3.esVacia() == false) {
            Object tope = pil3.obtenerTope();
            pil2.apilar(tope);
            pil3.desapilar();
        }
        if (pil.toString().equals(pil2.toString())) {
            verif = true;
        }
        return verif;
    }

}
