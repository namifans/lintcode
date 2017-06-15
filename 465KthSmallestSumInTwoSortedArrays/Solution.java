class Tuple {
	public int x, y, sum;
	public Tuple(int x, int y, int sum) {
		this.x = x;
		this.y = y;
		this.sum = sum;
	}
}
public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue<>(k, new Comparator<Tuple>() {
        	@Override
        	public int compare(Tuple a, Tuple b) {
        		return a.sum - b.sum;
        	}
        });
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int n = A.length;
        int m = B.length;
        boolean[][] hash = new boolean[n][m];
        heap.offer(new Tuple(0, 0, A[0] + B[0]));
        for (int i = 0; i < k - 1; i++) {
        	Tuple t = heap.poll();
        	for (int j = 0; j < 2; j++) {
        		int x = t.x + dx[j];
        		int y = t.y + dy[j];
        		if (x < n && y < m && !hash[x][y]) {
        			hash[x][y] = true;
	        		heap.offer(new Tuple(x, y, A[x] + B[y]));
        		}
        	}
        }
        return heap.peek().sum;
    }
}