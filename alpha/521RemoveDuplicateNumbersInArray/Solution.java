public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int head = 0, tail = 0;
        Arrays.sort(nums);
        while (tail < nums.length) {
            if (nums[head] != nums[tail] && head + 1 < nums.length) {
                nums[++head] = nums[tail];
            } else {
                tail++;
            }
        }
        return head + 1;
    }
}