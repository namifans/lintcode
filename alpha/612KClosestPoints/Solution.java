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
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || points.length == 0)
            return null;
        Point[] result = new Point[k];
        final Point o = origin;
        Queue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int distA = (a.x - o.x) * (a.x - o.x) + (a.y - o.y) * (a.y - o.y);
                int distB = (b.x - o.x) * (b.x - o.x) + (b.y - o.y) * (b.y - o.y);
                int diff = distA - distB;
                if (diff == 0) 
                    diff = a.x - b.x;
                if (diff == 0)
                    diff = a.y - b.y;
                return diff;
            }
        });
        for (Point p : points) {
            queue.add(p);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}