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
public class Upcase extends Processor{
    String process(Object input){ //Covariant return
        return((String)input).toUpperCase();
    }
}
