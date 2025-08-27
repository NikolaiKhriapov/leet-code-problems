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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int[] result = new int[] {-1};
        traverse(root, result, new int[] {k});

        if (result[0] == -1) {
            throw new IllegalArgumentException("Invalid input");
        }

        return result[0];
    }

    private void traverse(TreeNode node, int[] result, int[] k) {
        if (node == null) {
            return;
        }
        
        traverse(node.left, result, k);
        k[0]--;
        if (k[0] == 0) {
            result[0] = node.val;
            return;
        }
        traverse(node.right, result, k);
    }
}

// time  - O(n)
// space - O(n)
