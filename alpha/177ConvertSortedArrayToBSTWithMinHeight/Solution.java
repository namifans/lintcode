/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {

    Map<Integer, Integer> map = new HashMap<>(); //extra, no use in this problem
    /*
     * @param nums: an integer array
     * @return: nums tree node
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode node = createSubTree(nums, 0, nums.length - 1, 0);
        return node;
    }

    private TreeNode createSubTree(int[] nums, int left, int right, int height) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        map.put(root.val, height);
        root.left = createSubTree(nums, left, mid - 1, height + 1);
        root.right = createSubTree(nums, mid + 1, right, height + 1);
        return root;
    }
}