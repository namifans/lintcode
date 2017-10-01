/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        int[] dx = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Point p = queue.poll();
                if (p.x == destination.x && p.y == destination.y)
                    return count;
                for (int i = 0; i < 8; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x < n && x >= 0 && y >= 0 && y < m && grid[x][y] == false) {
                        queue.add(new Point(x, y));
                        grid[x][y] = true;
                    }
                }
                size--;
            }
            count++;
        }
        return -1;
    }
}