public class BubbleGrid {

    QuickUnion qu;
    int rows;
    int cols;



    public BubbleGrid(char[][] grid){
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.qu = new QuickUnion(rows * cols);

    }

    public int popBubbles(int[] dart, char[][] grid){
        grid[dart[0]][dart[1]] = 0;
        union(grid);
        int size = 0;
        for(int i = 0; i < rows * cols;i++ ){
            if(qu.sizeOf(i) > 1 && qu.find(i) >= cols &&qu.find(i) == i){
                size += qu.sizeOf(i);
            }
        }
        return size;
    }

    private void union(char[][] grid){
        int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            qu.union(id1, id2);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] charGrid = new char[3][3];
        for (int i = 0; i < charGrid.length; i++) {
            for (int j = 0; j < charGrid[0].length; j++) {
                charGrid[i][j] = Math.random() > 0.5 ? '1': '0';
            }
        }
        BubbleGrid grid = new BubbleGrid(charGrid);
        int[] dart = new int[]{2,2};
        int fallingBubbleNum = grid.popBubbles(dart, charGrid);
    }
}
