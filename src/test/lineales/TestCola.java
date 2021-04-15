/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.estaticas.Cola;

/**
 *
 * @author mateo
 */
public class TestCola {
    
    public static void main(String[] args) {
        
        Cola col1 = new Cola();
        Cola col2 = new Cola();
        
        col1.poner(1);
        col1.poner(2);
        col1.poner(3);
        col1.poner(4);
        col1.poner(5);
        col1.poner(6);
        col1.poner(7);
        col1.poner(8);
        col1.poner(9);
        col1.poner(10);
        col1.poner(11);
        //System.out.println(col1.esVacia());
        //col1.vaciar();
        col2 = col1.clone();
        System.out.println("Cola1: "+col1.toString());
        System.out.println(col1.obtenerFrente());
        System.out.println("Cola2: "+col2.toString());
        col1.sacar();
        col1.sacar();
        col1.poner(10);
        System.out.println("Cola1: "+col1.toString());
        System.out.println(col1.obtenerFrente());
        System.out.println("esvaciaCol1: "+col1.esVacia());
        col1.vaciar();
        System.out.println("esvaciaCol1: "+col1.esVacia());
        System.out.println(col1.toString());
        
    }
    
}
