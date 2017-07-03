public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
    	int left = 0, right = nums.length - 1;
    	int mid = (left + right) / 2;
    	while (left + 1 < right) {
    		if (nums[mid] == target) {
    			return mid;
    		}
    		else if (nums[mid] < target) {
    			right = mid;
    		} else {
    			left = mid;
    		}
    		mid = (left + right) / 2;
    	}
    	if (nums[left] == target)
    	    return left;
    	if (nums[right] == target)
    		return right;
    	return -1;
    }
}