public class Solution {
    /*
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length == 0) 
            return -1;
        Queue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }
}