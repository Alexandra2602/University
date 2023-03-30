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
public class ex6 {
static String result="";
static void test(int testval, int target)
    {
        if(testval> target) result="mai mare";
      
        else if (testval < target) result="mai mic";
        
        else result="egal";
            
        System.out.println(testval + result + target);
     
     
    }
public static void main(String[] args) {
Random rand = new Random(); 
int f[] = new int[25]; 
f[0]=rand.nextInt(100);
for(int i = 1; i < 25; i++)
{
f[i] = rand.nextInt(100); 
test (f[i-1],f[i]);
}
}
}

