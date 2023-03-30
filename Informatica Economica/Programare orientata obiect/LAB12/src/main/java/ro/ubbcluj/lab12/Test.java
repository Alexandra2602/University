/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab12;
import java.util.*;
/**
 *
 * @author alexandra
 */
public class Test {
    
    public static void main(String[] args){
        Companie c= new Companie(20);
        Random r=new Random();
        int nc;
        for(int i=0;i<20;i++)
        {
            nc=r.nextInt(10);
            try{
                if(nc<5) throw new NivelCompetentaInvalid ("Competenta <5 ! Invalid !");
            else
                if (r.nextInt(30)%2==0)
                    c.add(new Muncitor("N"+i, "p"+i,nc));
            else
                    c.add(new Vanzator("N"+i,"p"+i,nc));
            }
        
        catch (NivelCompetentaInvalid e)
                {
                System.out.println("Nivel invalid");
                            
                }
        }
    }
}
    

