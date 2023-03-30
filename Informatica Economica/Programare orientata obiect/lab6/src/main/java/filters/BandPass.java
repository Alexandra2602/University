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
public class BandPass extends Filter {
double lowCutoff, highCutoff;
public BandPass(double lowCut, double highCut) {
lowCutoff = lowCut;
highCutoff = highCut;
}
public Waveform process(Waveform input) { return input; } 
}
