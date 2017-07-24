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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        findSum(root, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void findSum(TreeNode root, int target, List<Integer> path, 
        List<List<Integer>> result) {
        if (root == null)
            return;
        List<Integer> newPath = new ArrayList();
        for (Integer i : path) {
            newPath.add(i);
        }
        if (root.val == target && root.left == null && root.right == null) {
            newPath.add(root.val);
            result.add(newPath);
            return;
        }
        newPath.add(root.val);
        findSum(root.left, target - root.val, newPath, result);
        findSum(root.right, target - root.val, newPath, result);
    }
}