public class Solution {
    /*
     * @param nums: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int pos = 1, neg = 1, currentPos = 1, currentNeg = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentPos++;
                currentNeg = 1;
            }
            else {
                currentNeg++;
                currentPos = 1;
            }
            pos = Math.max(pos, currentPos);
            neg = Math.max(neg, currentNeg);
        }
        return pos > neg ? pos : neg;
    }
}