class UnionFind {
    int[] father;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
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
}
public class ConnectingGraph { 

    UnionFind connectGraph;

    public ConnectingGraph(int n) {
        connectGraph = new UnionFind(n);
    }

    public void connect(int a, int b) {
        connectGraph.union(a - 1, b - 1);
    }
        
    public boolean query(int a, int b) {
        return (connectGraph.find(a - 1) == connectGraph.find(b - 1));
    }
}