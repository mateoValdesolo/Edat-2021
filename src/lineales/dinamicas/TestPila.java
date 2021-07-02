/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

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
        //int cont = 0;

        pil1.apilar(1);
        pil1.apilar(2);
        pil1.apilar(3);
        pil1.apilar(4);
        pil1.apilar(5);
        pil1.apilar(6);
        pil1.apilar(7);
        pil1.apilar(8);
        pil1.apilar(9);
        pil1.apilar(10);
        pil1.apilar(11);

        
        
        System.out.println(pil1.toString());
        pil2 = pil1.clone();
        System.out.println(pil2.toString());
        pil1.vaciar();
        System.out.println(pil2.toString());
        System.out.println(pil1.toString());

        
        
        /*for (int i = 0; i <= pil1.toString().length(); i++) {
            if (pil1.toString().charAt(i) != ' '){
                cont++;
            }
        }*/
        
    }

    

}
