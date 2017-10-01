public class Solution {
    /*
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int head = 0, tail = nums.length - 1;
        int current = 0;
        while (current <= tail) {
            if (nums[current] == 2) {
                swap(nums, tail, current);
                tail--;
            } else if (nums[current] == 0) {
                swap(nums, head, current);
                current++;
                head++;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}