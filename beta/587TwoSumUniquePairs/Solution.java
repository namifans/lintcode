public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int result = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                result++;
                l++;
                r--;
                while (l < nums.length - 1 && nums[l] == nums[l - 1])
                    l++;
                while (r >= 0 && nums[r] == nums[r + 1])
                    r--;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}