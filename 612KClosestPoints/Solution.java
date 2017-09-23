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
                double distA = Math.sqrt(Math.pow(a.x - o.x, 2) + Math.pow(a.y - o.y, 2));
                double distB = Math.sqrt(Math.pow(b.x - o.x, 2) + Math.pow(b.y - o.y, 2));
                if (distA < distB) {
                    return -1;
                } else if (distA > distB) {
                    return 1;
                } else {
                    if (a.x < b.x) {
                        return -1;
                    } else if (a.x > b.x) {
                        return 1;
                    } else {
                        if (a.y < b.y) {
                            return -1;
                        } else if (a.y > b.y) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
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