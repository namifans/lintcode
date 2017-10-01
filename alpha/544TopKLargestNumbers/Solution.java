public class Solution {
    /*
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        int[] result = new int[k];
        if (nums == null || nums.length == 0) 
            return result;
        if (nums.length < k)
            return nums;
        Queue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }
}