/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceprocessor;
import java.util.*;

/**
 *
 * @author alexandra
 */
public abstract class StringProcessor implements Processor {
    public String name() {return getClass().getSimpleName();}
    public abstract String process(Object input);
}
class Upcase extends StringProcessor{
    public String process(Object input){
    return ((String)input).toUpperCase();
}
}
class Downcase extends StringProcessor{
    public String process(Object input){
    return ((String)input).toLowerCase();
}
}
class Splitter extends StringProcessor{
    public String process(Object input){
    return Arrays.toString(((String)input).split(" "));
    }
}
