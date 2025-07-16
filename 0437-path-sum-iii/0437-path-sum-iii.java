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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return helper(root, 0L, targetSum, map);
    }

    private int helper(TreeNode node, long currSum, int targetSum, Map<Long, Integer> map) {
        if (node == null) {
            return 0;
        }

        currSum += node.val;

        int count = map.getOrDefault(currSum - targetSum, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        count += helper(node.left, currSum, targetSum, map);
        count += helper(node.right, currSum, targetSum, map);

        map.put(currSum, map.get(currSum) - 1);

        return count;
    }
}