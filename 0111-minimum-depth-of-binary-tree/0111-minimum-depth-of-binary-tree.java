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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            for (int i = 0, size = q.size(); i < size; i++) {
                root = q.poll();
                if (root.left == null && root.right == null) return depth;

                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }
            depth++;
        }

        return depth;
    }
}