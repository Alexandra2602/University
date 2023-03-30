/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab6;

/**
 *
 * @author alexandra
 */
public class Parcel { 
//clasa exterioara Parcel
class Contents { //clasa interioara Contents
private int i = 11;
public int value() { return i; }
}//end clasa inner
class Destination { //clasa interioara Destination
private String label;
Destination(String whereTo) {
label = whereTo;
}
String readLabel() { return label; }
}//end clasa inner
public Destination to(String s) {
//ob. din clasa int. Destination
return new Destination(s);
}
public Contents contents() {
//ob. din clasa int. Contents
return new Contents();
}
public void ship(String dest) {
Contents c = contents();
Destination d = to(dest);
System.out.println(d.readLabel());
}
public static void main(String[] args) {
Parcel p = new Parcel();
p.ship("Tasmania");
Parcel q = new Parcel();
// Defining references to inner classes:
//!!! accesul la clasa interioara Outer.inner
Parcel.Contents c = q.contents();
Parcel.Destination d = q.to("Borneo");
}
} //end clasa outter
    

