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
    private int countMax = 0;
    private int prev = Integer.MIN_VALUE;
    private List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        return listToArray(list);
    }

    private void helper(TreeNode node) {
        if (node == null) return;

        helper(node.left);

        if (node.val == prev) {
            count++;
        } else {
            count = 1;
        }
        if (count == countMax) {
            list.add(node.val);
        } else if (count > countMax) {
            countMax = count;
            list = new ArrayList<>(List.of(node.val));
        }
        prev = node.val;

        helper(node.right);
    }

    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
