/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab2;

/**
 *
 * @author alexandra
 */
class Letter
{
    char c;
}
public class PassObject {
    static void f(Letter y) {
y.c = 'z'; }
public static void main(String[] args) {
Letter x = new Letter(); //creare obiect x din clasa Letter
x.c = 'a';
System.out.println("1: x.c: " + x.c); //x.c are valoarea a
f(x); //aliasing
//x.c are valoare z - se trimite referinta la obiect ca si parametru si nu o copie a obiectului
System.out.println("2: x.c: " + x.c);
}
    
}
