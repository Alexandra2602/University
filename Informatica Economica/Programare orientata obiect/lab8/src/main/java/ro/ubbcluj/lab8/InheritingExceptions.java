/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab8;

/**
 *
 * @author alexandra
 */
class SimpleException extends Exception {}

public class InheritingExceptions {
public void f() throws SimpleException { // metoda este susceptibila sa arunce o exceptie
System.out.println("Throw SimpleException from f()"); throw new SimpleException(); // se arunca exceptia
}
public static void main(String[] args) {
InheritingExceptions sed = new InheritingExceptions();
try { // regiune guardata
sed.f();
} catch(SimpleException e) { // exceptia este prinsa si rezolvata
System.err.println("Caught it!");
}
}
}
