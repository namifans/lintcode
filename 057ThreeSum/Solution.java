public class Solution {
    /*
     * @param nums: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int head = i + 1, tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum == 0) {
                    result.add(Arrays.asList(new Integer[] {nums[i], nums[head], nums[tail]}));
                    head++;
                    tail--;
                    while (head < tail && nums[head] == nums[head - 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail + 1]) {
                        tail--;
                    }
                } else if (sum < 0) {
                    head++;
                } else {
                    tail--;
                }
            }
        }
        return result;
    }
}