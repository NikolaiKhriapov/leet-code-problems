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
    public int countNodes(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        handleNode(root, list);
        
        return list.size();
    }

    private void handleNode(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            handleNode(node.left, list);
            handleNode(node.right, list);
        }
    }
}