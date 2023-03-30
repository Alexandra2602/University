/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

/**
 *
 * @author alexandra
 */
public class HighPass extends Filter {
double cutoff;
public HighPass(double cutoff) {
this.cutoff = cutoff;
}
public Waveform process(Waveform input) { return input; }

    
}
