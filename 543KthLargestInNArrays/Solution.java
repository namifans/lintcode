class Tuple {
	public int x, y, val;
	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
    	PriorityQueue<Tuple> heap = new PriorityQueue<>(k, new Comparator<Tuple>() {
    		@Override
    		public int compare(Tuple a, Tuple b) {
    			return b.val - a.val;
    		}
    	});
    	int n = arrays.length;
    	for (int i = 0; i < n; i++) {
    		Arrays.sort(arrays[i]);
    		int m = arrays[i].length;
    		if (m > 0)
    			heap.offer(new Tuple(i, m-1, arrays[i][m-1]));
    	}
    	for (int i = 0; i < k-1; i++) {
    		Tuple t = heap.poll();
    		int y = t.y - 1;
    		if (y >= 0) {
    			heap.offer(new Tuple(t.x, y, arrays[t.x][y]));
    		}
    	}
    	return heap.peek().val;
    }
}