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
    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();

        traverse(root, set);
        
        if (set.size() < 2) {
            return false;
        }

        int p1 = 0;
        int p2 = 1;

        for (Integer v : set) {
            if (set.contains(k - v) && k - v != v) {
                return true;
            }
        }

        return false;
    }

    private void traverse(TreeNode root, Set<Integer> set) {
        if (root != null) {
            set.add(root.val);
            traverse(root.left, set);
            traverse(root.right, set);
        }
    }
}