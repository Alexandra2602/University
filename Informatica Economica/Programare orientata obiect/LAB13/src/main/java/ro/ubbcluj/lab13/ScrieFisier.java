/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab13;
import java.io.*;
/**
 *
 * @author alexandra
 */
public class ScrieFisier {
    public void scrie(Colet C) throws IOException{
        PrintWriter out=new PrintWriter("Comanda.txt");
        int lineCount=1;
        for(Produs pc:C.ListaProduse)
            out.println(pc.cod + " " +pc.pret);
        out.close();
    }
    
}
