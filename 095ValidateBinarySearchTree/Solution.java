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
    class Node {
        TreeNode node;
        long max;
        long min;
        public Node(TreeNode root, long max, long min) {
            this.node = root;
            this.max = max;
            this.min = min;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return verifyBST(new Node(root, Long.MAX_VALUE, Long.MIN_VALUE));
    }

    private boolean verifyBST(Node root) {
        if (root == null || root.node == null)
            return true;
        boolean left = verifyBST(new Node(root.node.left, root.node.val, root.min));
        boolean right = verifyBST(new Node(root.node.right, root.max, root.node.val));
        if (left && right && root.node.val > root.min && root.node.val < root.max)
            return true;
        else
            return false;
    }

}