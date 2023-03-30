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
class Book {
boolean checkedOut = false;
Book(boolean checkOut) { //constructor cu argument
checkedOut = checkOut; //initializeaza atributul checkedOut cu valoarea trimisa prin argument
}
void checkIn() { //metoda checkin
checkedOut = false;
}
protected void finalize() { //utilizarea finalize() in clasa Book
//inainte de distrugerea obiectelor cu garbage collector se va apela metoda finalize()
if(checkedOut) //daca atributul checkedOut e True - se afiseaza eroare
System.out.println("Error: checked out");
// Normally, you’ll also do this:
// super.finalize(); // Call the base-class version
}
}

public class TerminationCondition {
    public static void main(String[] args) {
Book novel = new Book(true); //creare obiect novel de tip Book
// Proper cleanup:
novel.checkIn(); //dupa utilizare - se da checkin() - obiectul se poate sterge
// Drop the reference, forget to clean up:
new Book(true); //se creaza un nou obiect din clasa Book
// Force garbage collection & finalization:
System.gc();
//se apeleaza garbage collector - ce determina executia finalize() din clasa Book
//pentru ca la cel de-al doilea obiect nu s-a apelat metoda checkIn() - se va afisa mesajul de eroare
}
    
}
