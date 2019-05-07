import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RankedQuickUnionFind {

    private int[] catalog;

    public RankedQuickUnionFind(int n) {
        this.catalog = new int[n];
        for(int i = 0; i < n; ++i) {
            this.catalog[i] = -1;
        }
    }

    public int sizeOf(int p) {
        int rootP = this.find(p);
        return -this.catalog[rootP];
    }

    public int parent(int p) {
        this.validate(p);
        return this.catalog[p];
    }

    public int find(int p) {
        this.validate(p);
        int resultIndex = -1;
        while(p >= 0) {
            resultIndex = p;
            p = this.catalog[p];
        }
        return resultIndex;
    }

    private void validate(int p) {
        int n = this.catalog.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index is invalid");
        }
    }

    public boolean connected(int p, int q) {
        return this.find(p) == this.find(q);
    }

    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP != rootQ) {
            if (-this.catalog[rootP] < -this.catalog[rootQ]) {
                this.catalog[rootQ] += this.catalog[rootP];
                this.catalog[rootP] = rootQ;
            } else {
                this.catalog[rootP] += this.catalog[rootQ];
                this.catalog[rootQ] = rootP;
            }

        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        RankedQuickUnionFind uf = new RankedQuickUnionFind(n);

        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
                StdOut.println(uf.catalog[0] + " "+ uf.catalog[1]+ " " + uf.catalog[2]+ " " + uf.catalog[3]+ " " + uf.catalog[4]+ " " +uf.catalog[5]+ " " +uf.catalog[6] + " "+uf.catalog[7] +" components");
            }
        }

    }
}
