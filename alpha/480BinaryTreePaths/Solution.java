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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        findPaths(root, new StringBuilder(), result);
        return result;
    }
    public void findPaths(TreeNode root, StringBuilder s, List<String> result) {
        if (root == null)
            return; 
        StringBuilder str = new StringBuilder(s);
        if (str.length() == 0)
            str.append(root.val);
        else
            str.append("->").append(root.val);
        if (root.left == null && root.right == null)
            result.add(str.toString());
        findPaths(root.left, str, result);
        findPaths(root.right, str, result);
    }
}