/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab8;
import java.util.logging.*;
import java.io.*;


/**
 *
 * @author alexandra
 */
class LoggingException extends Exception {
//asociem un obiect logger cu clasa Exceptie curenta
private static Logger logger = Logger.getLogger("LoggingException");
public LoggingException() { // constructor - se va executa ori de cate ori apare o exceptie StringWriter trace = new StringWriter();
printStackTrace(new PrintWriter(trace));
logger.severe(trace.toString());
}
}
public class LoggingExceptions {
public static void main(String[] args) {
try {
throw new LoggingException(); //se executa constructorul exceptiei
//executia sare la catch
} catch(LoggingException e) {
System.err.println("Caught " + e);
}
} }
