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

        handleNode(root, list);

        int p1 = 0;
        int p2 = 0;

        int size = list.size();
        while (p1 < size) {
            while (p2 < size) {
                if (p1 != p2 && list.get(p1) + list.get(p2) == k) return true;
                else p2++;
            }
            p1++;
            p2 = p1 + 1;
        }

        return false;
    }

    private void handleNode(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            handleNode(node.left, list);
            handleNode(node.right, list);
        }
    }
}