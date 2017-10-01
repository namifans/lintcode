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
        public TreeNode root;
        public int sum;
        public int size;
        public Node(TreeNode root, int sum, int size) {
            this.root = root;
            this.sum = sum;
            this.size = size;
        }
    }

    private Node max;
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null)
            return null;
        Node node = findMaximum(root);
        return max.root;        
    }

    public Node findMaximum(TreeNode root) {
        if (root == null)
            return new Node(null, 0, 0);
        Node left = findMaximum(root.left);
        Node right = findMaximum(root.right);
        Node current = new Node(root, 
            left.sum + right.sum + root.val, 
            left.size + right.size + 1);
        if (max == null || (current.sum * max.size > max.sum * current.size))
            max = current;
        return current; 
    }
}