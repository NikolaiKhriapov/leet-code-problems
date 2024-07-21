/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) searchBT(root, "", result);
        return result;
    }

    public void searchBT(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) result.add(path + node.val);
        if (node.left != null) searchBT(node.left, path + node.val + "->", result);
        if (node.right != null) searchBT(node.right, path + node.val + "->", result);
    }
}