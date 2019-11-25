package algorithms1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;
import java.util.Arrays;

class PercolationStats {
	double percTresholdArray[];
	int opSites[];
	double mean;
	double standardDev;
	int nTrials;
	
	//Constructor
	public PercolationStats(int n, int trials) {
		 percTresholdArray = new double[trials];
		 nTrials = trials;
		 
		 for (int i=0; i<trials; i++) {
		 	Percolation monteCarlo = new Percolation(n);
		 	while(!monteCarlo.percolates()) {
				monteCarlo.open(StdRandom.uniform(1, n+1), StdRandom.uniform(1, n+1));				
			}
		 	percTresholdArray[i] = ((double)monteCarlo.numberOfOpenSites()/(n*n));
		 }
	}    // perform trials independent experiments on an n-by-n grid
	
	public double mean() {
		mean = StdStats.mean(percTresholdArray);
		return mean;
	}                         // sample mean of percolation threshold
	public double stddev() {
		 standardDev =  StdStats.stddev(percTresholdArray);
		 return standardDev;
	}                        // sample standard deviation of percolation threshold
	public double confidenceLo() {
		return (mean - 1.960*(standardDev/Math.sqrt(nTrials)));
	}                  // low  endpoint of 95% confidence interval
	public double confidenceHi() {
		return (mean + 1.960*(standardDev/Math.sqrt(nTrials)));
	}                  // high endpoint of 95% confidence interval

	public static void main(String[] args) {
		PercolationStats percStats = new PercolationStats(1000, 10);
		System.out.println(percStats.mean());
		System.out.println(percStats.stddev());
		System.out.println(Arrays.toString(percStats.percTresholdArray));
	}   // testing

}
