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
        boolean hasA;
        boolean hasB;
        TreeNode lca;
        public Node(boolean hasA, boolean hasB, TreeNode lca) {
            this.hasA = hasA;
            this.hasB = hasB;
            this.lca = lca;
        }
    }
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return root;
        Node n = findNodes(root, A, B);    
        return n.lca;
    }

    private Node findNodes(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return new Node(false, false, null);
        Node left = findNodes(root.left, A, B);
        Node right = findNodes(root.right, A, B);
        if (left.lca != null)
            return left;
        if (right.lca != null)
            return right;  
        boolean hasA = root.val == A.val || left.hasA || right.hasA;
        boolean hasB = root.val == B.val || left.hasB || right.hasB;
        TreeNode lca = null;
        if (hasA && hasB)
            lca = root;
        return new Node(hasA, hasB, lca);
    }
}