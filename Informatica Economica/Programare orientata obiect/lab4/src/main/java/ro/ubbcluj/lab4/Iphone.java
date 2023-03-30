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
class Component1{
    Component1(){
        System.out.println("Componenta1");
    }
}
class Component2{
    Component2(){
        System.out.println("Componenta2");
    }
}
class Component3{
    Component3(){
        System.out.println("Componenta3");
    }
}
class Smartphone {
    private Component1 c1;
    private Component2 c2;
    private Component3 c3;
    public Smartphone() {
        c1=new Component1();
        c2=new Component2();
        c3=new Component3();
        System.out.println("Smartphone constructor");}
}
public class Iphone extends Smartphone {
    public static void main(String[] args){
        Iphone x=new Iphone();
    }
}
