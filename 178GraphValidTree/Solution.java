public class Solution {
    int father[];

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
        }
    }

    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        father = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int rx = find(x);
            int ry = find(y);
            if (rx == ry)
                return false;
            union(rx, ry);
        }
        return true;
    }
}