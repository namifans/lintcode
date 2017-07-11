public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) 
                return mid;
            else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target))
            return left;
        else
            return right;
    }
}