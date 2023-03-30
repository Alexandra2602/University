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

public class SpaceShipDelegation {
    private String name;
//compozitie cu clasa SpaceShipControls
private SpaceShipControls controls = new SpaceShipControls();
public SpaceShipDelegation(String name) {
this.name = name; //utilizarea this pentru a diferentia argumentul de atributul clasei
}
// metode delegate - din clasa SpaceShipControls
public void back(int velocity) {
controls.back(velocity);
}
public void down(int velocity) {
controls.down(velocity);
}
public void forward(int velocity) {
controls.forward(velocity);
}
public void left(int velocity) {
controls.left(velocity);
}
public void right(int velocity) {
controls.right(velocity);
}
public void turboBoost() {
controls.turboBoost();
}
public void up(int velocity) {
controls.up(velocity);
}
public static void main(String[] args) {
SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
protector.forward(100);
}
}
