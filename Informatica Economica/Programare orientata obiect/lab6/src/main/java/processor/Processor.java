/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processor;

/**
 *
 * @author alexandra
 */
public class Processor {
    public String name() {return getClass().getSimpleName();}
    Object process(Object input) {return input;}  
}
