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
public class OperatieAdapter implements Operatie{
    OperatieTrigonometrica ot;
    public OperatieAdapter(OperatieTrigonometrica op)
    {
        this.ot=op;
    }
    public float calculeaza(float a, float b){
        return ot.calculeaza(a, b);
    }
    
}
