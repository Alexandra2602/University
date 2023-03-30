/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab11;

/**
 *
 * @author alexandra
 */
public class Test {
    public static void Main(String[] args){
        Client c=new Client();
        Aeroport a= new Aeroport();
        a.CreeazaAeronava(new AvionPersoaneFactory(), "Stuttgart");
        a.CreeazaAeronava(new AvionCargoFactory(), "Berlin");
        a.NumarAvioane();
        try{
            c.search("londra");
        }
        catch (NoDestinationFound e){
            System.out.println("Exceptie prinsa" +e);
    }
    }
}
    

