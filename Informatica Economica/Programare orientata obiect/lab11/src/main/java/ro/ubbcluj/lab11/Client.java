/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab11;
import java.util.*;
/**
 *
 * @author alexandra
 */
public class Client {
    void search(String destinatie) throws NoDestinationFound{
        int contor=0;
        for(Aeronava a: Aeroport.ListaAvioane){
            if (a.getDestinatie().equals(destinatie));
            contor++;
            
        }
        if(contor==0) throw new NoDestinationFound("Nici un avion nu a fost gasit");
        else System.out.println("S-au gasit" +contor +"avioane");
        
    }
    
}
