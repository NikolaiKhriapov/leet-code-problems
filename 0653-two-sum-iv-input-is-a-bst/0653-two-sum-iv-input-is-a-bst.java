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
        
        if (list.size() < 2) return false;

        int p1 = 0;
        int p2 = 1;

        while (p1 < list.size()) {
            while (p2 < list.size()) {
                System.out.println(list.get(p1) + " " + list.get(p2));
                if (p1 != p2 && list.get(p1) + list.get(p2) == k) {
                    return true;
                }
                p2++;
            }
            p1++;
            p2 = p1;
        }

        return false;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            traverse(root.left, list);
            traverse(root.right, list);
        }
    }
}