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

        int maxLevelSum = Integer.MIN_VALUE;
        int maxSumLevel = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currLevelSum = 0;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                currLevelSum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            currLevel++;
            if (currLevelSum > maxLevelSum) {
                maxLevelSum = currLevelSum;
                maxSumLevel = currLevel;
            }
        }
        
        return maxSumLevel;
    }
}