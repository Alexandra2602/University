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
class WaterSource {
private String s;
WaterSource() {
System.out.println("WaterSource()");
s = "Constructed";
}
public String toString() { return s; }
}
public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
// se face compozitie:un obiect din clasa WaterSource ca si atribut
private WaterSource source = new WaterSource(); //se apeleaza contructor WaterSource
private int i;
private float f;
public String toString() { //mecanism de conversie inspre clasa String
return
"valve1 = " + valve1 + " " +
"valve2 = " + valve2 + " " +
"valve3 = " + valve3 + " " +
"valve4 = " + valve4 + "\n" +
"i = " + i + " " + "f = " + f + " " +
"source = " + source;
}
public static void main(String[] args) {
SprinklerSystem sprinklers = new SprinklerSystem();
System.out.println(sprinklers); //se printeaza continutul obiectului
//se face conversie conform metodei toString()
}
    
}
