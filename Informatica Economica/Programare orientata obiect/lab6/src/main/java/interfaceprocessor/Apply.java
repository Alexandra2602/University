/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceprocessor;

/**
 *
 * @author alexandra
 */
public class Apply {
    public static void process(Processor p, Object s) {
System.out.println("Using Processor " + p.name());
System.out.println(p.process(s));
}
public static String s = "If she weighs the same as a duck, she’s made of wood";
public static void main(String[] args) { Apply.process(new Upcase(), s);
Apply.process(new Downcase(), s);
Apply.process(new Splitter(), s);
}
    
}
