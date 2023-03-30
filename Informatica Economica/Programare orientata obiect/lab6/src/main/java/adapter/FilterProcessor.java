/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;
import interfaceprocessor.*;
import filters.*;
/**
 *
 * @author alexandra
 */

class FilterAdapter implements Processor {
Filter filter; //compozitia cu clasa de baza Filter
public FilterAdapter(Filter filter) { // pot sa initializez cu orice obiect din ierarhia Filter
this.filter = filter;
}
//accesez functionalitatile din ierarhia Filter prin membrul Filter
public String name() { return filter.name(); }
public Waveform process(Object input) {
return filter.process((Waveform)input);
}
}
public class FilterProcessor {
public static void main(String[] args) {
Waveform w = new Waveform();
//upcasting LowPass->Filter
Apply.process(new FilterAdapter(new LowPass(1.0)), w);
//upcasting HighPass->Filter
Apply.process(new FilterAdapter(new HighPass(2.0)), w);
//upcasting BandPass->Filter
Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
}
}