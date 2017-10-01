public class Solution {
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int current = 0;
        int head = 0, tail = nums.length - 1;
        while (current < tail) {
            while (nums[head] < k && head < tail) {
                head++;
                if (head > current)
                    current++;
            }
            while (nums[tail] >= k && current < tail) {
                tail--;
            }
            swap(nums, head, tail);
        }
        return current == nums.length - 1 ? current + 1 : current;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}