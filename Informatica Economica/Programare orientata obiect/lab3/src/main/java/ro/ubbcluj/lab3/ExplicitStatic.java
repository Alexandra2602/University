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
class Cup {
Cup(int marker) {
System.out.println("Cup(" + marker + ")");
}
void f(int marker) {
System.out.println("f(" + marker + ")");
}
}
class Cups {
static Cup cup1;
static Cup cup2;
static { // blocul static explicit de initializare
cup1 = new Cup(1);
cup2 = new Cup(2);
}
Cups() { // constructor default
System.out.println("Cups()");
}
}
public class ExplicitStatic {
    public static void main(String[] args) {
System.out.println("Inside main()");
Cups.cup1.f(99); // (1) acces la membrii statici fara instantiere
//initializarea statica se face si in acest caz - prin simpla referire
}
//initializarea statica se face inainte de instantiere - la incarcarea clasei
//static Cups cups1 = new Cups(); // (2)
//static Cups cups2 = new Cups(); // (2) }
    
}
