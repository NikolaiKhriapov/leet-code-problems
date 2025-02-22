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
    Map<TreeNode, Integer> map = new HashMap<>();
    
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.val = Math.abs(helper(root.left) - helper(root.right));

        findTilt(root.left);
        findTilt(root.right);

        return helper(root);
    }

    private int helper(TreeNode node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        List<Integer> list = new ArrayList<>();
        
        subhelper(node, list);
        
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        
        map.put(node, sum);
        
        return sum;
    }

    private void subhelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        subhelper(node.left, list);
        list.add(node.val);
        subhelper(node.right, list);
    }
}