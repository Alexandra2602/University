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
class Mug {
Mug(int marker) {
System.out.println("Mug(" + marker + ")");
}
void f(int marker) {
System.out.println("f(" + marker + ")");
}
}
public class Mugs {
    Mug mug1;
Mug mug2;
{ // bloc non-static de initializare - se face la fiecare instantiere cu new a clasei
mug1 = new Mug(1);
mug2 = new Mug(2);
System.out.println("mug1 & mug2 initialized");
}
Mugs() {
System.out.println("Mugs()");
}
Mugs(int i) {
System.out.println("Mugs(int)");
}
public static void main(String[] args) {
System.out.println("Inside main()");
Mugs o1 = new Mugs(); //determina initializare a atributelor in o1
System.out.println("new Mugs() completed");
Mugs o2 = new Mugs(1); //determina reinitializarea atributelor in o2 (o1 raman neschimbate)
System.err.println("new Mugs(1) completed");
//o1 si o2 sunt doua obiecte distincte (instante ale clasei Mugs)
//a caror atribute non-statice pot lua valori diferite in fiecare obiect
}
    
}
