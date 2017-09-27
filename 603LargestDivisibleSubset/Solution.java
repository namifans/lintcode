public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) 
            return result;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        int max = 0, maxIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if (max < dp[i]) {
                        max = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }
        for (int i = 0; i < max; i++) {
            result.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}