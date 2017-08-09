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
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}