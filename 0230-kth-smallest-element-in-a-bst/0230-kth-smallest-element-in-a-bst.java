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

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        if (list.size() < k) {
            throw new IllegalArgumentException("Invalid input");
        }

        return list.get(k - 1);
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
}

// time  - O(n)
// space - O(n)
