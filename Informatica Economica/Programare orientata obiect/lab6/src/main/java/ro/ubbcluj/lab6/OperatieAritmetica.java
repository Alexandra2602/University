/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab6;

/**
 *
 * @author alexandra
 */
public class OperatieAritmetica implements Operatie{
    public float calculeaza(float a, float b){
    return 0;}
    }
  
class OperatieAdunare extends OperatieAritmetica{
    public float calculeaza(float a, float b){
        return (a+b);}
    }

class OperatieScadere extends OperatieAritmetica{
    public float calculeaza(float a, float b){
        return (a-b);}
    }

class OperatieInmultire extends OperatieAritmetica{
    public float calculeaza(float a, float b){
        return (a*b);}
    }
