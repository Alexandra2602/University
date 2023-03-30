/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab5;

/**
 *
 * @author alexandra
 */
class Animal{
    public void eat(){}
}

class Lion extends Animal{
    public void eat(){System.out.println("Acesta este un leu");}
}
class Zebra extends Animal{
    public void eat(){System.out.println("Aceasta este o zebra");}
    
}
public class Jungle {
    public static void live(Animal a){
        a.eat();
    }
    public static void main (String[] args) {
        Lion l= new Lion();
        Zebra z=new Zebra();
        live(l);
    }
    
}
