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
class Actor {
public void act() {}
}
class HappyActor extends Actor {
//folosim mostenirea pentru a schimba comportamente specifice
public void act() {System.out.println("HappyActor");}
}
class SadActor extends Actor {
public void act() { System.out.println("SadActor"); }
}
class Stage {
//folosim compozitia pentru a schimba starea obiectelor prin apel de contructor
private Actor actor = new HappyActor();//starea initiala a obiectului actor
public void change() { actor = new SadActor(); } //modificare starii obiectului actor
public void performPlay() { actor.act(); }
}

public class Transmogrify {
 public static void main(String[] args) {
Stage stage = new Stage();
stage.performPlay();
stage.change();
stage.performPlay();
}   
}
