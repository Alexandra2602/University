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
class Super {
public int field = 0;
public int getField() {return field; }
}
class Sub extends Super {
public int field = 1;
public int getField() { return field; }
public int getSuperField() { return super.field; }
}
public class FieldAccess {
    public static void main(String[] args) {
Super sup = new Sub(); // Upcast - construim ob. clasa Super cu constructorul clasei Sub
//sup.field = 0 - se afiseaza valoarea din clasa de baza
//sup.getField()=1 - se afiseaza valoarea din clasa derivata (suprascrierea atributelor nu e posibila)
System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
Sub sub = new Sub();
System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField() +
", sub.getSuperField() = " + sub.getSuperField());
}
    
}
