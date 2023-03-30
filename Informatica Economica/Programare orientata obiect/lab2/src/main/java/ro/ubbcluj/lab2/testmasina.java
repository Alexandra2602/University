/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab2;

/**
 *
 * @author alexandra
 */
public class testmasina {
    public static void main(String[] args)
    {
        Masina m=new Masina("verde",100, "ford",2009);
        m.porneste();
        m.accelereaza(90);
        m.opreste();
    }
    
}
