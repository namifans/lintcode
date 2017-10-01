public class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    bfsIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfsIsland(boolean[][] grid, int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        grid[x][y] = false;
        queue.offer(new Coordinate(x, y));
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < grid.length 
                    && ny >= 0 && ny < grid[0].length 
                    && grid[nx][ny]) {
                    grid[nx][ny] = false;
                    queue.offer(new Coordinate(nx, ny));
                }
            }
        }
    }
}