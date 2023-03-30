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
class Plate {
Plate(int i) {
System.out.println("Plate constructor");
}
}
class DinnerPlate extends Plate {
DinnerPlate(int i) {
super(i);
System.out.println("DinnerPlate constructor");
}
}
class Utensil {
Utensil(int i) {
System.out.println("Utensil constructor");
}
}
class Spoon extends Utensil {
Spoon(int i) {
super(i);
System.out.println("Spoon constructor");
}
}
class Fork extends Utensil {
Fork(int i) {
super(i);
System.out.println("Fork constructor");
}
}
class Knife extends Utensil {
Knife(int i) {
super(i);
System.out.println("Knife constructor");
}
}
class Custom {
Custom(int i) {
System.out.println("Custom constructor");
}
}
public class PlaceSetting extends Custom {
private Spoon sp; //compozitie cu Spoon
private Fork frk; //compozitie cu Fork
private Knife kn;
private DinnerPlate pl;
public PlaceSetting(int i) {
super(i + 1); //(1) contructor clasa de baza Custom
sp = new Spoon(i + 2); //apelul constructorului Spoon va fi precedat de apelul constructorului clasei de baza
frk = new Fork(i + 3); //idem
kn = new Knife(i + 4); //idem
pl = new DinnerPlate(i + 5); //apel contructor DinnerPlate precedat de apel constructor clasa de baza
System.out.println("PlaceSetting constructor");
}
public static void main(String[] args) {
PlaceSetting x = new PlaceSetting(9);
}
} 
    
    

