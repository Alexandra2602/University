/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab4;

/**
 *
 * @author alexandra
 */
class Instrument { //clasa de baza 
public void play() {System.out.println("canta");}
static void tune(Instrument i) {
i.play();
}
}
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind(); //Wind e si de tipul clasei de baza - Instrument
        Instrument.tune(flute); // Upcasting !!! aici e upcast
    }
    
}
