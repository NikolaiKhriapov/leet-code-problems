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
    private int count = 0;
    private int maxCount = 0;
    private TreeNode prev = null;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        return listToArray(modes);
    }

    private void helper(TreeNode node) {
        if (node == null) return;

        helper(node.left);

        if (prev == null || node.val == prev.val) {
            count++;
        } else {
            count = 1;
        }
        prev = node;
        if (count == maxCount) {
            modes.add(node.val);
        } else if (count > maxCount) {
            maxCount = count;
            modes = new ArrayList<>(List.of(node.val));
        }

        helper(node.right);
    }

    private int[] listToArray(List<Integer> list) {
        int[] result = new int[modes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = modes.get(i);
        }
        return result;
    }
}