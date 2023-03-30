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
public class Sequence {
    private Object[] items; //colectia de iterat
private int next = 0; //indice
public Sequence(int size) { items = new Object[size]; }
public void add(Object x) {
if(next < items.length)
items[next++] = x;
}
private class SequenceSelector implements Selector { private int i = 0;
public boolean end() { return i == items.length; }
public Object current() { return items[i]; }
public void next() { if(i < items.length) i++; }
}
public Selector selector() {
return new SequenceSelector();
}
public static void main(String[] args) {
Sequence sequence = new Sequence(10);
for(int i = 0; i < 10; i++)
sequence.add(Integer.toString(i));
Selector selector = sequence.selector();
while(!selector.end()) {
System.out.print(selector.current() + " ");
selector.next();
}
}
}
