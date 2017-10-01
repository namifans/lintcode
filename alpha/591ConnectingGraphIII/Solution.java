public class ConnectingGraph3 {
    int father[];
    int count;

    private int find(int x) {
        if (father[x] == x)
            return x;
        return father[x] = find(father[x]);
    }

    private void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            father[rx] = ry;
            count--;
        }
    }

    public ConnectingGraph3(int n) {
        father = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
            count = n;
        }
    }

    public void connect(int a, int b) {
        union(a, b);
    }
        
    public int query() {
        return count;
    }
}