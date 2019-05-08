public class QuickUnion {

    private int[] parent;
    private int[] size;
    private int count;

    public QuickUnion(int n){
        this.size = new int[n];
        this.parent = new int[n];
        for(int i = 0; i< n; i++){
            this.size[i] = 1;
            this.parent[i] = i;
        }
        count = n;
    }

    public void validate(int v1){
        int n = parent.length;
        if (v1 < 0 || v1 >= n) {
            throw new IllegalArgumentException("index " + v1 + " is not between 0 and " + (n-1));
        }
    }

    public int sizeOf(int v1){
        int root = find(v1);
        return this.size[root];
    }

    public boolean connected(int v1, int v2){
        return find(v1) == find(v2);
    }

    public void union(int v1, int v2){
        int root = find(v1);
        int childRoot = find(v2);
        if(root != childRoot){
            this.parent[childRoot] = root;
            this.size[root] += 1;
            count--;
        }
    }

    public int find(int v1){
        validate(v1);
        while(v1 != this.parent[v1]){
            v1 = this.parent[v1];
        }
        return v1;
    }
}
