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
        handleNode(root, list);
        return list;
    }

    public void handleNode(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                handleNode(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                handleNode(node.right, list);
            }
        }
    }
}