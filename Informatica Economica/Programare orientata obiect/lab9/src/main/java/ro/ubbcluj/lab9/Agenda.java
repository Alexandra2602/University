/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab9;
import java.io.*;
import java.util.*;
/**
 *
 * @author alexandra
 */
public class Agenda {
    public List<Persoana>p=new ArrayList<Persoana>();
    
    
    public void citeste(String adresaFisier) throws IOException{
  //Reading input by lines:
    
BufferedReader in= new BufferedReader(new FileReader(adresaFisier));
String s;
String datep[]=null;
while((s=in.readLine())!=null)
    datep=s.split(" ");
importa (datep[0],datep[1],datep[2]);

in.close();
}
    public void importa(String tip, String nume,String prenume)
    {
        if (tip.equals("Prieten")) p.add(new Prieten(nume,prenume));
        else p.add(new Coleg(nume,prenume));
    }
}
