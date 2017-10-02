public class Solution {
    /*
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < nums.length - 2 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int max = Integer.MIN_VALUE;
        if (left < nums.length) {
            max = nums[left];
        } 
        if (right >= 0 && nums[right] > max) {
            max = nums[right];
        }
        return max;
    }
}