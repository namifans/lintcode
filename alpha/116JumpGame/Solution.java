public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] jump) {
        if (jump == null || jump.length == 0)
            return false;
        int n = jump.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && jump[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }        
        return dp[n - 1];
    }
}
