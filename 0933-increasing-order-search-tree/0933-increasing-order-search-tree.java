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
    public TreeNode increasingBST(TreeNode root) {
        
        List<TreeNode> list = new ArrayList<>();

        handleNode(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i + 1);
        }
        TreeNode last = list.get(list.size() - 1);
        last.left = null;
        last.right = null;

        return list.get(0);
    }

    public void handleNode(TreeNode root, List<TreeNode> list) {
        if (root.left != null) handleNode(root.left, list);
        list.add(root);
        if (root.right != null) handleNode(root.right, list);
    }
}