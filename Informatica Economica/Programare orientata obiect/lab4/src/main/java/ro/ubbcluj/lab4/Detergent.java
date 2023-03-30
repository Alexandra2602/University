/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab4;

/**
 *
 * @author alexandra
 */class Cleanser {
private String s = "Cleanser";
public void append(String a) { s += a; }
public void dilute() { append(" dilute()"); }
public void apply() { append(" apply()"); }
public void scrub() { append(" scrub()"); }
public String toString() { return s; }
public static void main(String[] args) {
Cleanser x = new Cleanser();
x.dilute(); x.apply(); x.scrub();
System.out.println(x);
}
}
public class Detergent extends Cleanser {
    // schimbarea functionalitatii metodei scrub() din clasa de baza
public void scrub() {
append(" Detergent.scrub()");//metoda append din clasa de baza
super.scrub(); // apel metoda scrub() din clasa de baza
}
// Adaugarea de metode specifice clasei derivate
public void foam() { append(" foam()"); }
// Test the new class:
public static void main(String[] args) {
//Detergent are toate metodele din clasa de baza
//+noile metode implemenate sau suprascrise in Detergent
Detergent x = new Detergent();
x.dilute();
x.apply();
x.scrub();
x.foam();
System.out.println(x);
System.out.println("Testing base class:");
Cleanser.main(args); //apel metoda main - statica
}
  
}
