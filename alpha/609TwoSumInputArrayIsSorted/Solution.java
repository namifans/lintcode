public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) 
            return null;
        int head = 0, tail = nums.length - 1;
        while (head != tail) {
            if (nums[head] + nums[tail] == target) {
                result[0] = head + 1;
                result[1] = tail + 1;
                return result;
            } else if (nums[head] + nums[tail] < target) {
                head++;
            } else {
                tail--;
            }
        }
        return result;
    }
}