class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
    	Queue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
    	int count = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (count < k) {
    			heap.offer(nums[i]);
    			count++;
    		} else {
    			if (nums[i] < heap.peek()) {
    				heap.poll();
    				heap.offer(nums[i]);
    			}
    		}
    	}
    	return heap.poll().intValue();
    }
};