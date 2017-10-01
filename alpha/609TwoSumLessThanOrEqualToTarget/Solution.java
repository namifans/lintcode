public class Solution {
    /**
    * @param nums an array of integer
    * @param target an integer
    * @return an integer
    */
    public int twoSum5(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1, count = 0;
        Arrays.sort(nums);
        while(l < r) {
            if (nums[l] + nums[r] <= target) {
                count += r - l;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}