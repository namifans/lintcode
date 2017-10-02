public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int up = 0, down = n - 1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][m / 2] == target) {
                return true;
            } else if (matrix[mid][m / 2] < target) {
                up = mid + 1;
            } else {
                down = mid - 1;
            }
        }
        boolean result = false;
        if (up < n) 
            result |= searchRow(matrix[up], target);
        if (down >= 0)
            result |= searchRow(matrix[down], target);
        return result;
    }

    private boolean searchRow(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}