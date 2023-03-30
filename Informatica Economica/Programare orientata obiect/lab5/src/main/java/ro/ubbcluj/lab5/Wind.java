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
public class Wind extends Instrument { // redefinim metoda din interfata:
public void play(Note n) { // metoda play() este suprascrisa
System.out.println("Wind.play() " + n);
}
}