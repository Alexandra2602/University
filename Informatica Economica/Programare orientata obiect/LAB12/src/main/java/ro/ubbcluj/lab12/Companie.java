/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab12;

/**
 *
 * @author alexandra
 */

interface Pers{ //operatii ale unui iterator
    boolean end();
    Persoana current();
    void next();
}
public class Companie {
    private Persoana[] angajati; //colectie de iterat
 
private int next=0; //indice
public Companie(int size) { angajati= new Persoana[size];}
public void add(Persoana x){
    if (next< angajati.length)
        angajati[next++]=x;
}

private class CompaniePers implements Pers{
    private int i=0;
    public boolean end(){ return i == angajati.length;}
    public Persoana current() { return angajati[i];}
    
    public void next() {if (i< angajati.length)i++;}
}
public Pers Persoana(){
    return new CompaniePers();
    
}
    
    
}
