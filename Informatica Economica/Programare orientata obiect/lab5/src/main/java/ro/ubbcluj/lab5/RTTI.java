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
class Useful {
public void f() {System.out.println("Useful f()");}
public void g() {System.out.println("Useful g()");}
}
class MoreUseful extends Useful {
public void f() { System.out.println("MoreUseful f()");}
public void g() { System.out.println("MoreUseful g()");}
public void u() { System.out.println("MoreUseful u()");}
public void v() { System.out.println("MoreUseful v()");}
public void w() { System.out.println("MoreUseful w()");}
}
public class RTTI {
    public static void main(String[] args) {
Useful[] x = { new Useful(), new MoreUseful()};
x[0].f();
x[1].g();
// Eroare la timp de compilare: metoda u() nu este gasita in Useful:
//x[1].u();
//se face conversie dinspre tipul de baza spre tipul derivat x[1]-de tip MoreUseful
((MoreUseful)x[1]).u(); // Downcast/RTTI
//x[0] - de tip Useful nu are metoda u()
//desi se face conversie catre tipul MoreUseful, exceptia este aruncata
((MoreUseful)x[0]).u();
}
}
