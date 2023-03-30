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
public class ex7 {
    private static void genFibonacci (long nr)
    {
        long x=nr;
        long a=1, b=1, c=2;
        if(x==1) { System.out.println("1 1");}
        else {System.out.println("1 ");
        do {
            c=a+b;
            a=b;
            b=c;
            System.out.println(a+ " ");
        }
        while (c<=x);
        }
    }
  private static long citire ()
  {
      int ok=1;
      long x=0;
      do{
          try{
              Scanner input=new Scanner(System.in);
              x=input.nextInt();
              if(x<1)
              {
                  ok=0;
                  System.out.println("Introduceti un nr intreg pozitiv");
              }
              else ok=1;
          }
          catch(Exception e)
          {
              System.out.println("Trebuie introdus un numar: ");
              ok=0;
          }
      }
      while(ok==0);
      return x;
  }
  public static void main (String[] args)
  {
      long nr=citire();
      genFibonacci(nr);
  }
}
