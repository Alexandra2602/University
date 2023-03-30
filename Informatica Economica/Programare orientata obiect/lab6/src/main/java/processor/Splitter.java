/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processor;
import java.util.*;
/**
 *
 * @author alexandra
 */
public class Splitter extends Processor {
    String process(Object input){
        return Arrays.toString(((String)input).split(""));
    }  
}
