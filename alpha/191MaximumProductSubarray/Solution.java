public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (i <= 0) {
                pos[i] = nums[i];
                neg[i] = nums[i];
            } else {
                pos[i] = Math.max(nums[i], Math.max(nums[i] * pos[i - 1], nums[i] * neg[i - 1]));
                neg[i] = Math.min(nums[i], Math.min(nums[i] * pos[i - 1], nums[i] * neg[i - 1]));
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }
}