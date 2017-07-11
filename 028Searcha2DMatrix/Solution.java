public class Solution {
    /**
    * @param matrix, a list of lists of integers
    * @param target, an integer
    * @return a boolean, indicate whether matrix contains target
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        if (matrix[0] == null || matrix[0].length == 0)
            return false;
        int start = 0, end = matrix.length - 1, row = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target){
            row = start;
        } else
        return false;
        return binarySearch(matrix[row], target);
    }

    private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                left = mid;
            else
                right = mid;
        }
        if (nums[left] == target || nums[right] == target)
            return true;
        else
            return false;
    }
}
