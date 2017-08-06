public class ConnectingGraph { 

    int[] father;

    public int find(int x) {
        if (father[x] == x)
            return x;
        return father[x] = find(father[x]);
    }

    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            father[rx] = ry;
        }
    }

    public ConnectingGraph(int n) {
        father = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        union(a, b);
    }
        
    public boolean query(int a, int b) {
        return find(a) == find(b);
    }
}