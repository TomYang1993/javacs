package hw2;


import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    double[] fractions;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if(N <= 0 || T <= 0){
            throw new IllegalArgumentException("Illegal T and N!");
        }

        fractions = new double[40];
        for(int i = 0; i < fractions.length; i++) {
            pf = new PercolationFactory();
            Percolation percolate = pf.make(N);
            while(!percolate.percolates()){
                int indexOfOpen = StdRandom.uniform(N*N);
                int col = indexOfOpen % N;
                int row = (indexOfOpen - col) / N;
                percolate.open(row, col);
            }
            fractions[i] = percolate.numberOfOpenSites();
        }


    }
    public double mean(double[] fractions){
        return StdStats.mean(fractions);
    }

    public double stddev(double[] fractions){
        return StdStats.stddev(fractions);
    }

    public double confidenceLow(double[] fractions, int T)  {
        return mean(fractions) - 1.96 * stddev(fractions) / Math.sqrt(T) ;
    }

    public double confidenceHigh(double[] fractions, int T) {
        return mean(fractions) + 1.96 * stddev(fractions) / Math.sqrt(T) ;
    }

    public static void main(String[] args){

    }

}
