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
class Game {
Game(int i) {
System.out.println("Game constructor");
}
}
class BoardGame extends Game { //clasa derivata din Game
BoardGame(int i) {
super(i); //apel constructor clasa de baza (Game)
System.out.println("BoardGame constructor");
}
}
public class Chess extends BoardGame{
    Chess() {
super(11); //apel constructor clasa de baza BoardGame
System.out.println("Chess constructor");
}
public static void main(String[] args) {
Chess x = new Chess();
}
    
}
