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
        int sum;
        public Node(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
    private Node min;
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        if (root == null)
            return root;
        findMin(root);
        return min.node;
    }
    private Node findMin(TreeNode root) {
        if (root == null)
            return new Node(root, 0);
        Node left = findMin(root.left);
        Node right = findMin(root.right);
        int sum = left.sum + right.sum + root.val;
        Node current = new Node(root, sum);
        if (min == null || sum <= min.sum) {
            min = current;
        }
        return current;
    }
}
