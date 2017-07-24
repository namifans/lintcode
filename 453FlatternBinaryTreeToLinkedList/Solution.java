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
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        traverse(root);
    }
    public TreeNode traverse(TreeNode root) {
        if (root == null)
            return root;
        TreeNode lastLeft = traverse(root.left);
        TreeNode lastRight = traverse(root.right);
        if (lastLeft != null) {
            lastLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (lastRight != null)
            return lastRight;
        if (lastLeft != null)
            return lastLeft;
        return root;
    }
}