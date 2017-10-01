public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return target;
        int head = 0, tail = nums.length - 1;
        int min = Integer.MAX_VALUE; 
        Arrays.sort(nums);
        while (head < tail) {
            int current = nums[head] + nums[tail];
            int diff = Math.abs(target - current);
            if (diff < min) {
                min = diff;
            }
            if (current < target) {
                head++;
            } else {
                tail--;
            }
        }
        return min;
    }
}