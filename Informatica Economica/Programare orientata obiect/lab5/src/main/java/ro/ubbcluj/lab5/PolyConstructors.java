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

class Glyph {
void draw() {
System.out.println("Glyph.draw()");
}
Glyph() {
System.out.println("Glyph() before draw()");
draw(); // Atentie: care draw() va fi apelat?
//se va apela functia draw() din clasa derivata
//dar valoarea lui atributului radius nu va fi 1
System.out.println("Glyph() after draw()");
}
}
class RoundGlyph extends Glyph {
private int radius = 1;
RoundGlyph(int r) {
//se face apel automat la constructorul fara argumenente din clasa de baza
radius = r;
System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
}
void draw() {
System.out.println("RoundGlyph.draw(), radius = " + radius);
}
}
public class PolyConstructors {
    public static void main(String[] args) {
new RoundGlyph(5);
//Glyph - are constructor fara argumente
//constructorul RoundGlyph asigura apelul automat
//al cosntructorului fara argumente din clasa de baza }
    }    
}
