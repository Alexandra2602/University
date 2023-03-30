/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab3;

/**
 *
 * @author alexandra
 */
public class Ex9 {
   String shops;
    Ex9(String s){
        shops=s;
        System.out.println("Creating a shop that is: "+shops);
    }
    public static void main(String[] args){
        String[] shops={"Zara", "H&M","Mango", "Stradivarius"};
       int i;
       for(i=0;i<shops.length;i++){
           System.out.println(shops[i]);
       }
       Ex9 s1=new Ex9("");
       Ex9 s2=new Ex9("");
       Ex9 s3=new Ex9("");
       Ex9 s4=new Ex9("");
       s1.shops="Zara";
       s2.shops="H&M";
       s3.shops="Mango";
       s4.shops="Stadivarius";
       System.out.println("s1: "+s1.shops +" s2: "+s2.shops+ " s3: "+s3.shops+ " s4: "+s4.shops);
       
       
    }
}
