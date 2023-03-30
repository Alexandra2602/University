/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab8;

/**
 *
 * @author alexandra
 */
public class Rethrowing {
public static void f() throws Exception {
System.out.println("originating the exception in f()");
throw new Exception("thrown from f()");
}
public static void g() throws Exception { try {
f();
} catch(Exception e) {
System.out.println("Inside g(),e.printStackTrace()"); e.printStackTrace(System.out);
throw e; //rearuncarea exceptiei
}
}
public static void h() throws Exception { try {
f();
} catch(Exception e) {
System.out.println("Inside h(),e.printStackTrace()"); e.printStackTrace(System.out);
throw (Exception)e.fillInStackTrace();
}
}
public static void main(String[] args) {
try {
g();
} catch(Exception e) {
System.out.println("main: printStackTrace()"); e.printStackTrace(System.out);
}
try {
h();
} catch(Exception e) {
System.out.println("main: printStackTrace()"); e.printStackTrace(System.out);
}
}
}
