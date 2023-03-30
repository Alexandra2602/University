/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab13;

import java.io.IOException;

/**
 *
 * @author alexandra
 */
public class Test {
    public static void main (String[] args){
        Comanda C=new Comanda();
        C.c.ListaProduse.add(new Produs (111,200));
        C.c.ListaProduse.add(new Produs (144,500));
        C.c.afiseazacolet();
        System.out.println("Ati comandat" + C.c.ListaProduse.size()+ "produse");
        ScrieFisier s= new ScrieFisier();
        try{
            s.scrie(C.c);
        }
        catch(IOException e)
        {
            System.out.println("eroare scriere fisier");
            
        }
        C.proceseaza();
        C.c.afiseazacolet();
        
    }
    
}
