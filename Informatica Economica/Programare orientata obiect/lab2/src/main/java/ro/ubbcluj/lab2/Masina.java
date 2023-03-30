/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab2;

/**
 *
 * @author alexandra
 */
public class Masina {
    public String culoare;
    public Integer putere_cp;
    public String marca;
    private Integer an_fabricatie;
    
    public void porneste(){System.out.println("Masina de culoare " + culoare + " si marca " + marca + " a pornit");};
    public void opreste(){System.out.println("Masina a oprit");};
    public Integer accelereaza(Integer viteza){
        System.out.println("Masina a accelarat la viteza"+ viteza);
        return viteza;};
    public Integer franeaza(Integer distanta){return distanta;};
    
    
    Masina(String c, Integer cp, String m, Integer anf){
        culoare=c;
        putere_cp=cp;
        marca=m;
        an_fabricatie=anf;
        
    };
}
