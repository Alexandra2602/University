/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab4;

/**
 *
 * @author alexandra
 */

class Vehicle {
       Vehicle (int i) {System.out.println("Vehicle constructor");}
}
public class Car extends Vehicle {
    Car(int i)
    {
        super(i);
        System.out.println("Car");
    }
    Car()
    {
        super(11);
        System.out.println("Car constructor");
    }
    public static void main (String[] args)
    {
        Car x=new Car();
    }
    
}
