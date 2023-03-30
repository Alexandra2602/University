/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab3;

/**
 *
 * @author maria
 */
class Bowl {
Bowl(int marker) { //constructor in clasa Bowl
System.out.println("Bowl(" + marker + ")");
}
void f1(int marker) { //metoda in clasa Bowl
System.out.println("f1(" + marker + ")");
}
}
class Table {
static Bowl bowl1 = new Bowl(1); //(init. 1) membru static de tip Bowl in clasa Table
Table() { //apelul constructor se face dupa initializarea atributelor statice din clasa
System.out.println("Table()");
bowl2.f1(1); //apel catre metoda f1()
}
void f2(int marker) { //metoda in clasa Table
System.out.println("f2(" + marker + ")");
}
static Bowl bowl2 = new Bowl(2); //(init. 2) membru static de tip Bowl in clasa Table
}
class Cupboard {
//initializarea membrilor non-statici se face dupa initializarea celor statici din clasa
Bowl bowl3 = new Bowl(3); //membru non static de tip Bowl in Cupboard
static Bowl bowl4 = new Bowl(4); //(init.3) membru static de tip Bowl in clasa CupBoard
Cupboard() { //constructor in Cupboard
System.out.println("Cupboard()");
bowl4.f1(2);
}
void f3(int marker) {
System.out.println("f3(" + marker + ")");
}
static Bowl bowl5 = new Bowl(5);//(init. 4) membru static
}
public class StaticInitialization {
    public static void main(String[] args) {
System.out.println("Creating new Cupboard() in main");
new Cupboard();
System.out.println("Creating new Cupboard() in main - !!!atributele statice nu mai sunt initializate");
new Cupboard(); //!!! la a doua instantiere se initializeaza doar atributele non-statice
table.f2(1);
cupboard.f3(1);
}
static Table table = new Table();
static Cupboard cupboard = new Cupboard(); 
}
