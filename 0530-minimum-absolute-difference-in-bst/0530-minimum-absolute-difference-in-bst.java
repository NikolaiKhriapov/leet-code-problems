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
    public int getMinimumDifference(TreeNode root) {
        Set<Integer> set = new HashSet<>();

        handleNode(root, set);

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int diff = list.get(list.size() - 1);
        for (int i = 0; i < list.size() - 1; i++) {
            int tmp = list.get(i + 1) - list.get(i);
            if (tmp < diff) {
                diff = tmp;
            }
        }

        return diff;
    }

    private void handleNode(TreeNode node, Set<Integer> set) {
        if (node != null) {
            set.add(node.val);
            if (node.left != null) {
                handleNode(node.left, set);
            }
            if (node.right != null) {
                handleNode(node.right, set);
            }
        }
    }
}