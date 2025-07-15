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

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int maxLevelSum = Integer.MIN_VALUE;
        int level = 0;

        int currLevel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            while (size-- > 0) {
                TreeNode curr = queue.pollFirst();
                levelSum += curr.val;
                if (curr.left != null) {
                    queue.offerLast(curr.left);
                }
                if (curr.right != null) {
                    queue.offerLast(curr.right);
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