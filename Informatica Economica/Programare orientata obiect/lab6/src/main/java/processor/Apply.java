/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processor;
import java.util.*;
import filters.*;
/**
 *
 * @author alexandra
 */
class Processor {
public String name() { return getClass().getSimpleName(); }
Object process(Object input) { return input; }
}
class Upcase extends Processor {
String process(Object input) { // Covariant return
return ((String)input).toUpperCase();
}
}
class Downcase extends Processor {
String process(Object input) {
return ((String)input).toLowerCase();
}
}
class Splitter extends Processor {
String process(Object input) {
return Arrays.toString(((String)input).split(" "));
}
}

public class Apply {
    public static void process(Processor p, Object s) {
System.out.println("Using Processor " + p.name());
System.out.println(p.process(s));
}
public static String s = "Disagreement with beliefs is by definition incorrect";
public static void main(String[] args) {
process(new Upcase(), s);
process(new Downcase(), s);
process(new Splitter(), s);
//(1)
// Waveform w = new Waveform();
//process(new LowPass(1.0),w);
//process(new HighPass(2.0),w);
//process(new BandPass(3.0),w);
////liniile de mai sus nu vor functiona prin apelul process()
////desi clasa Filter are aceleasi elemente in interfata: name() si process()
////insa Filter nu este mostenita din Processor 
}
    
}
