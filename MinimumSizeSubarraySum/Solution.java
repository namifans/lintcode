public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int result = Integer.MAX_VALUE, sum = 0, j = 0;
        for (int i = 0; i < nums.length; i ++) {
        	while (j < nums.length) {
        		if (sum + nums[j] >= s) {
        			result = Math.min(j - i + 1, result);
        			break;
        		} else {
		    		sum += nums[j++];
        		}
        	}
        	sum -= nums[i];
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}