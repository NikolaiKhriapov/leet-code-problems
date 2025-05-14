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
            return 0;
        }

        List<Integer> listOfSums = new ArrayList<>();
        helper(root, 0, listOfSums);
        return calculateTotal(listOfSums);        
    }

    private void helper(TreeNode node, int currSum, List<Integer> listOfSums) {
        if (node == null) return;
        
        currSum = currSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            listOfSums.add(currSum);
            return;
        }

        if (node.left != null) {
            helper(node.left, currSum, listOfSums);
        }
        if (node.right != null) {
            helper(node.right, currSum, listOfSums);
        }
    }

    private int calculateTotal(List<Integer> listOfSums) {
        int result = 0;
        for (int sum : listOfSums) {
            result += sum;
        }
        return result;
    }
}