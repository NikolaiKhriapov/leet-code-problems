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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxLevelSum = Integer.MIN_VALUE;
        int level = 0;

        int currLevel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                levelSum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                level = currLevel;
            }
            currLevel++;
        }
        
        return level;
    }
}