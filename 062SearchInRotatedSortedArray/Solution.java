public class Solution {
    /** 
     *@param nums : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            } 
            if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }
}
