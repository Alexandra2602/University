/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab3;

/**
 *
 * @author alexandra
 */
class Tree {
int height;
Tree() { //constructor implicit fara argumente
System.out.println("Planting a seedling");
height = 0;
}
//constructorii supraincarcati ofera flexibilitate in initialirea obiectelor
Tree(int initialHeight) { //acelasi constructor Tree supraincarcat cu un argument
height = initialHeight;
System.out.println("Creating new Tree that is " + height + " feet tall");
}
//metode supraincarcate
void info() { //metoda info fara argumente cu tip de return void
System.out.println("Tree is " + height + " feet tall");
}
void info(String s) { //metoda info cu argumente cu tip de return void
System.out.println(s + ": Tree is " + height + " feet tall"); }
}
public class Overloading {
    public static void main(String[] args) {
for(int i = 1; i < 5; i++) {
Tree t = new Tree(i); //instantiere utilizand constructorul supraincarcat cu un argument
t.info(); //apel metoda info() fara argumente
t.info("overloaded method"); //apel metoda info cu argument
}
Tree t=new Tree(); //instantierea obiectului t prin constructorul fara argument
}
        
}
