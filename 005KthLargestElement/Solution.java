class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        Queue<Integer> heap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
        	heap.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
			heap.poll();
		}
        return heap.peek().intValue();
    }
}