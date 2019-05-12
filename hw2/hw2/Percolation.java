package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] grid;
    private int numOfOpenSites;
    private WeightedQuickUnionUF wuf;
    private int rowLength;
    private static final int[][] direction = {{1,0},{0,-1},{-1,0},{0,1}};

    private int getIndex(int row, int col){
        return row * rowLength + col;
    }

    private void validateIJ(int row, int col) {
        if (!(row >= 0 && row < rowLength && col >= 0 && col < rowLength)) {
            throw new IndexOutOfBoundsException("Index is not betwwen 0 and N-1");
        }
    }

    public Percolation(int N){
        if(N <= 0){
            throw new java.lang.IllegalArgumentException("Illegal arguments!");
        }
        wuf = new WeightedQuickUnionUF(N * N + 2);
        grid = new boolean[N*N];
        for(int i = 0; i < N*N ;i++){
           grid[i] = false;
        }
        rowLength = N;

    }

    public void open(int row, int col)   {
        if(!isOpen(row, col)){
            int index = getIndex(row, col);
            grid[index] = true;
            numOfOpenSites++;

            if(row == 0){
                wuf.union(getIndex(row,col), rowLength*rowLength + 1);
            }

            if(row == rowLength - 1){
                wuf.union(getIndex(row,col), rowLength*rowLength + 2);
            }

            for(int[] d: direction) {
                int orthodoxRow = row + d[1];
                int orthodoxCol = col + d[0];
                if(orthodoxRow >=0 && orthodoxRow < rowLength && orthodoxCol >= 0 && orthodoxCol < rowLength && isOpen(orthodoxRow, orthodoxCol)){
                    wuf.union(getIndex(row,col), getIndex(orthodoxRow, orthodoxCol));
                }
            }


        }
    }

    public boolean isOpen(int row, int col){
        int index = getIndex(row, col);
        return grid[index];
    }

    public boolean isFull(int row, int col) {
        return wuf.connected(getIndex(row, col), rowLength*rowLength + 1);
    }

    public int numberOfOpenSites(){
        return numOfOpenSites;
    }

    public boolean percolates() {
        return wuf.connected(rowLength*rowLength + 1, rowLength*rowLength + 2);
    }

    public static void main(String[] args) {
        Percolation percolate = new Percolation(0);
    }


}
