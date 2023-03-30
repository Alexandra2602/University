/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab13;

/**
 *
 * @author alexandra
 */
public class Comanda {
    int nrcomanda;
    public Colet c=new ColetComandat();
    
    public void proceseaza(){ c=new ColetExpediat();}
    public void afiseazastare(){c.afiseazacolet();}
    
}
