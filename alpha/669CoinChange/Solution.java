public class Solution {
    /**
     * @param coins  a list of integer
     * @param amount a total amount of money amount
     * @return the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins , int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        int n = coins.length;
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (coins[j] != 0 && i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = ans;
        }
        if (dp[amount] == Integer.MAX_VALUE)
            dp[amount] = -1;
        return dp[amount];
    }
}