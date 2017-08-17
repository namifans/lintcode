class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        Queue<Point> queue = new LinkedList<>();
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        int people = 0;
        int wall = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    queue.add(new Point(i, j));
                else if (grid[i][j] == 0) {
                    people++;
                } else {
                    wall++;
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Point p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) {
                        queue.add(new Point(x, y));
                        grid[x][y] = 1;
                        people--;
                        if (people == 0)
                            return count + 1;
                    }
                }
                size--;
            }
            count++;
        }
        return -1;
    }
}