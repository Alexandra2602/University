/**
 * 
 */
package com.services.axis2server;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author alexandra
 *
 */
public class PiQuasiMonteCarloService {
	
	public static final int SAMPLE_MAX_SIZE = 10;
	
	private boolean withinUnitCircle(double ox, double oy){
		return ox*ox + oy*oy<=1;
	}
	
	public String[] computePi(long nbIter, double samplePct)
	{
		Random rnd = new Random();
		ArrayList<String> sample = new ArrayList<String>();
		double ox, oy;
		
		long withinCircle = 0;
		for(long i = 1; i<=nbIter; i++){
			//generate a random point (ox,oy) in the square [-1,1]x[-1,1]
			ox=rnd.nextDouble()*2 - 1;
			oy=rnd.nextDouble()*2 - 1;
			//test if the generated point lies within the unit circle
			// centered in (0,0) and radius 1
			withinCircle += withinUnitCircle(ox,oy)?1:0;
	
			//add the point to the sample of points
			//if the sample does not exceed some MAX SIZE
			if(sample.size() < SAMPLE_MAX_SIZE &&
					rnd.nextDouble()<=samplePct ) sample.add(ox + ";" + oy);
		}
		// the number of iterations
		// and the number of circle points to the result
		// on the first two positions
		sample.add(0,withinCircle + "");
		sample.add(0,nbIter + "");
		
		String[] res = new String[sample.size()];
		sample.toArray(res);
		return res;
	}
}