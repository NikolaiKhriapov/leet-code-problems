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

        int[] arr = new int[set.size()];
        int count = 0;
        for (int n : set) {
            arr[count] = n;
            count++;
        }
        Arrays.sort(arr);

        int diff = arr[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = arr[i + 1] - arr[i];
            if (tmp < diff) diff = tmp;
        }

        return diff;
    }

    private void handleNode(TreeNode node, Set<Integer> set) {
        if (node != null) {
            set.add(node.val);
            if (node.left != null) handleNode(node.left, set);
            if (node.right != null) handleNode(node.right, set);
        }
    }
}