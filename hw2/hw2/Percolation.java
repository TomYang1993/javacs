package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] grid;
    private int numOfOpenSites;
    private WeightedQuickUnionUF wuf;
    private WeightedQuickUnionUF wufTop;
    private int rowLength;
    private static final int[][] direction = {{1,0},{0,-1},{-1,0},{0,1}};
    private int top = rowLength*rowLength;
    private int bottom = rowLength*rowLength + 1;

    private int getIndex(int row, int col){
        validateIJ(row, col);
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
        wufTop = new WeightedQuickUnionUF(N * N + 1);
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
                wuf.union(index, top);
                wufTop.union(index, top);
            }

            if(row == rowLength - 1){
                wuf.union(index, bottom);
            }

            for(int[] d: direction) {
                int orthodoxRow = row + d[1];
                int orthodoxCol = col + d[0];
                if(orthodoxRow >=0 && orthodoxRow < rowLength && orthodoxCol >= 0 && orthodoxCol < rowLength && isOpen(orthodoxRow, orthodoxCol)){
                    wuf.union(index, getIndex(orthodoxRow, orthodoxCol));
                    wufTop.union(index, getIndex(orthodoxRow, orthodoxCol));
                }
            }

        }
    }

    public boolean isOpen(int row, int col){
        int index = getIndex(row, col);
        return grid[index];
    }

    public boolean isFull(int row, int col) {
        if(isOpen(row, col)){
            int index = getIndex(row, col);
            return wufTop.connected(index, top);
        }else{
            return false;
        }
    }

    public int numberOfOpenSites(){
        return numOfOpenSites;
    }

    public boolean percolates() {
        return numberOfOpenSites() > 0 && wuf.connected(top, bottom);
    }

    public static void main(String[] args) {
    }


}
