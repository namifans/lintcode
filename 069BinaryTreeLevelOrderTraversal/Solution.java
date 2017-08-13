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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversal(root, result, 0);
        return result;
    }

    public void traversal(TreeNode root, ArrayList<ArrayList<Integer>> list, int depth) {
        if (root == null)
            return;
        ArrayList<Integer> current = new ArrayList<>();
        if (depth == 0) {
            current.add(root.val);
            list.add(current);
        } else {
            if (depth < list.size() && list.get(depth) != null) {
                current = list.get(depth);
                current.add(root.val);
            } else {
                current.add(root.val);
                list.add(current);
            }
        }
        traversal(root.left, list, depth + 1);
        traversal(root.right, list, depth + 1);
    }
}