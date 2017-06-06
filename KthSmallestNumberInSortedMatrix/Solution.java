class Tuple {
	public int x;
	public int y;
	public int val;
	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}	
public class Solution {

    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<Tuple> heap = new PriorityQueue<>(k, new Comparator<Tuple>() {
        	@Override
        	public int compare(Tuple a, Tuple b) {
        		return a.val - b.val;
        	}
        });
        int[] dx = new int[] {0, 1};
        int[] dy = new int[] {1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] hash = new boolean[n][m];
        heap.offer(new Tuple(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; i ++) {
        	Tuple t = heap.poll();
        	for (int j = 0; j < 2; j ++) {
        	    int x = t.x + dx[j];
        	    int y = t.y + dy[j];
        		if (x < n && y < m && !hash[x][y]) {
        			hash[x][y] = true;
        			heap.offer(new Tuple(x, y, matrix[x][y]));
        		}
        	}	
        }
        return heap.peek().val;
    }
}

