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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        helper(root, list);
        
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            helper(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            helper(node.right, list);
        }
    }
}