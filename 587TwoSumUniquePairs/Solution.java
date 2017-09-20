public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int head = 0, tail = nums.length - 1;
        int result = 0;
        Arrays.sort(nums);
        while (head < tail) {
            int current = nums[head] + nums[tail];
            if (current == target) {
                result++;
                head++;
                tail--;
                while(nums[head] == nums[head-1] && head < nums.length - 1) {
                    head++;
                }
                while(nums[tail] == nums[tail+1] && tail > 0) {
                    tail--;
                }
            } else if (current < target) {
                head++;
            } else {
                tail--;
            }
        }
        return result;
    }
}