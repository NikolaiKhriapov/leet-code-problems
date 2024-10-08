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
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        
        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            if (list.get(l) + list.get(r) > k) {
                r--;
            } else if (list.get(l) + list.get(r) < k) {
                l++;
            } else {
                return true;
            }
        }

        return false;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            traverse(root.left, list);
            list.add(root.val);
            traverse(root.right, list);
        }
    }
}