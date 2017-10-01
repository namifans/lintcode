public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0)
            return -1;
        int n = triangle.length;
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle[i].length];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (i + 1 < n)
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
                else
                    dp[i][j] = triangle[i][j];
            }
        }
        return dp[0][0];
    }
}
