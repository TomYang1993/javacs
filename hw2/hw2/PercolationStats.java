package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private double mean;
    private double stddev;
    private double confidenceLow;
    private double confidenceHigh;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if(N <= 0 || T <= 0){
            throw new IllegalArgumentException("Illegal T and N!");
        }

        double[] fractions = new double[T];
        for(int i = 0; i < fractions.length; i++) {
            Percolation percolate = pf.make(N);
            while(!percolate.percolates()){
                int indexOfOpen = StdRandom.uniform(N*N);
                int col = indexOfOpen % N;
                int row = (indexOfOpen - col) / N;
                percolate.open(row, col);
            }
            fractions[i] = percolate.numberOfOpenSites();
        }

        mean = StdStats.mean(fractions);
        stddev = StdStats.stddev(fractions);
        confidenceLow = mean - 1.96 * stddev / Math.sqrt(T);
        confidenceHigh = mean + 1.96 * stddev / Math.sqrt(T);
    }
    public double mean(){
        return mean;
    }

    public double stddev(){
        return stddev;
    }

    public double confidenceLow()  {
        return confidenceLow;
    }

    public double confidenceHigh() {
        return confidenceHigh;
    }

}
