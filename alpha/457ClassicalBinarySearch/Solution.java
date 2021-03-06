public class Solution {
    /**
    * @param nums: An integer array sorted in ascending order
    * @param target: An integer
    * @return an integer
    */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
    int mid = left + (right - left) / 2; // Avoid overflow
    if (nums[mid] == target) {
        return mid;
    }
    else if (nums[mid] < target) {
        left = mid;
    } else {
        right = mid;
    }
    }
    if (nums[left] == target)
        return left;
    if (nums[right] == target) 
        return right;
    return -1;
    }
}