/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

    int father[];
    int count = 0;

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

    private int convert(int x, int y, int m) {
        return x * m + y;
    }

    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0 || m <= 0 || operators == null || operators.length == 0)
            return result;
        father = new int[n * m + 1];
        for (int i = 0; i < n * m + 1; i++) {
            father[i] = i;
        }
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int[][] island = new int[n][m];
        for (int i = 0; i < operators.length; i++) {
            Point p = operators[i];
            if (island[p.x][p.y] != 1) {
                count++;
                island[p.x][p.y] = 1;
                for (int j = 0; j < 4; j++) {
                    int px = p.x + dx[j];
                    int py = p.y + dy[j];
                    if (px >= 0 && px < n && py >= 0 && py < m && island[px][py] == 1) {
                        int current1d = convert(p.x, p.y, m);
                        int target1d = convert(px, py, m);
                        int rootCurrent = find(current1d);
                        int rootTarget = find(target1d);
                        if (rootCurrent != rootTarget) {
                            union(current1d, target1d);      
                            count--;
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}