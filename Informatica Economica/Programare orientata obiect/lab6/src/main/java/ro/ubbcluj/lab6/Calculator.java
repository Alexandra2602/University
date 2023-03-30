/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab6;
import java.util.*;
/**
 *
 * @author alexandra
 */
public class Calculator {
    public static void process(Operatie p, float a, float b){
        System.out.println("Rezultatul este: "+p.calculeaza(a, b));
    }
    public static void main(String[] args) {
        float a=5,b=3;
        Calculator.process(new OperatieAdunare(),a,b);
        Calculator.process(new OperatieScadere(),a,b);
        Calculator.process(new OperatieInmultire(),a,b);
        Calculator.process(new OperatieAdapter( new OperatieSinus()),a,b);
        Calculator.process(new OperatieAdapter(new OperatieCosinus()),a,b);
    }
   
}
