public class ConnectingGraph2 {
    int[] father;
    int[] size;

    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            father[rx] = ry;
            size[ry] += size[rx];
        }
    }

    public ConnectingGraph2(int n) {
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public void connect(int a, int b) {
        union(a, b);
    }
        
    public int query(int a) {
        int ra = find(a);
        return size[ra];
    }
}