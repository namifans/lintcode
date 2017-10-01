public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid] && nums[mid] > nums[right])
                left = mid;
            else 
                right = mid;
        }
        return Math.min(nums[left], nums[right]);
    }
}