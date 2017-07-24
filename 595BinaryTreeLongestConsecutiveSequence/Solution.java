/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return findLongest(root, root, 0);
    }
    public int findLongest(TreeNode root, TreeNode parent, int length) {
        if (parent == null || root == null)
            return 0;
        if (root.val == parent.val + 1)
            length++;
        else {
            length = 1;
        }
        int left = findLongest(root.left, root, length);
        int right = findLongest(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }
}