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

    public class Music {
public static void tune(Instrument i) {
i.play(Note.MIDDLE_C);
}
public static void main(String[] args) {
Wind flute = new Wind(); //obiectul flute este in acelasi timp si de tipul Instrument
//functia tune() asteapta un argument de tip Instrument dar accepta si obiecte de tip Wind
tune(flute); // Upcast– se va executa metoda play() din clasa Wind
}
    
}
