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

        int level = 0;
        int maxSum = Integer.MIN_VALUE;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);

        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            currLevel++;
            int currSum = 0;
            while (size-- > 0) {
                TreeNode node = queue.pollFirst();
                currSum += node.val;
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
            if (currSum > maxSum) {
                maxSum = currSum;
                level = currLevel;
            }
        }
        
        return level;
    }
}