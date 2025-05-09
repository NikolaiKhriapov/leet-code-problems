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
        StringBuilder curr = new StringBuilder(root.val);
        curr.append(root.val);
        helper(root, curr, list);
        return getSum(list);
    }

    private void helper(TreeNode node, StringBuilder curr, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(Integer.parseInt(curr.toString()));
            return;
        }

        if (node.left != null) {
            curr.append(node.left.val);
            helper(node.left, curr, list);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (node.right != null) {
            curr.append(node.right.val);
            helper(node.right, curr, list);
            curr.deleteCharAt(curr.length() - 1);
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