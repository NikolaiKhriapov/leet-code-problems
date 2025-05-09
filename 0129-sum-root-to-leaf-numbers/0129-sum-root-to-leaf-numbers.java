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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<Integer> list = new ArrayList<>();
        helper(root, root.val, list);
        return getSum(list);
    }

    private void helper(TreeNode node, Integer curr, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(curr);
            return;
        }

        if (node.left != null) {
            helper(node.left, curr * 10 + node.left.val, list);
        }
        if (node.right != null) {
            helper(node.right, curr * 10 + node.right.val, list);
        }
    }

    private int getSum(List<Integer> list) {
        int result = 0;
        for (int n : list) {
            result += n;
        }
        return result;
    }
}