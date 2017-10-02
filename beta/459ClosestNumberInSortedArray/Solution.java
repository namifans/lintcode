public class Solution {
    /*
     * @param nums: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
            return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left > nums.length - 1) {
            return right;
        }
        if (right < 0) {
            return left;
        }
        if (Math.abs(target - nums[left]) < Math.abs(target - nums[right])) {
            return left;
        } else {
            return right;
        }
    }
}