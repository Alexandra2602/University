/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab2;
import java.util.*;

/**
 *
 * @author alexandra
 */
public class ForEachFloat {
    public static void main(String[] args) {
Random rand = new Random(47); //obiect ce genereaza numere random
float f[] = new float[10]; // crearea arrayului de numere reale
for(int i = 0; i < 10; i++)
f[i] = rand.nextFloat(); // initializarea fiecarui element din array - parcurgere
for(float x : f) //parcurgere vector f element cu element
System.out.println(x);
/*echivalent cu: for(int i=0;i<f.length;i++)
* {
* x=f[i];
* System.out.println(x);
* }
*/
}
}
