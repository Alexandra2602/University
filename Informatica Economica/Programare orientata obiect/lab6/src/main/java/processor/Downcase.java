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
public class Downcase extends Processor{
    String process(Object input){ 
        return((String)input).toLowerCase();
    }
}

   
