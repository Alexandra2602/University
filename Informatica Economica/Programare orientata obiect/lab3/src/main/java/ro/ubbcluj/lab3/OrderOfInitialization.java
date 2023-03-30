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
class Window {
Window(int marker) { //constructor
System.out.println("Window(" + marker + ")");
}
}
class House {
Window w1 = new Window(1); // (1) initializare (apelul constructorului Window din clasa Window)
// se face inainte de apelul constructorului House()
House() { //constructor in clasa House()
// Show that we’re in the constructor:
System.out.println("House()");
w3 = new Window(33); // (4) reinitializare w3 dupa ce ultima initializare implicita a avut loc (pct. 3)
}
Window w2 = new Window(2); // (2) initializare inainte de apelul constructorului House()
void f(){
System.out.println("f()");
}
Window w3 = new Window(3); //(3) ultima initializare implicita - inainte de apelul constructorului House()
}

public class OrderOfInitialization {

public static void main(String[] args) {
//instantierea ob House (apelul constructorului House()) determina initializarea in ordinea de mai sus
House h = new House();
h.f(); // Shows that construction is done
}
}
    

