/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab9;
import java.io.*;
/**
 *
 * @author alexandra
 */
public class Test {
    public static void main(String[] args) throws IOException{
        Agenda a =new Agenda();
        a.citeste("C:\\Users\\maria\\OneDrive\\Desktop\\LAB9");
        for(Persoana pp: a.p)
            if(pp instanceof Prieten) SocialMedia.socializare(new Facebook(), pp);
            else SocialMedia.socializare(new Twitter(),pp);
        
    }
    
}
