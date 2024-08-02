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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (root != null) handleNode(root, list, result);
        
        return result;
    }

    private void handleNode(TreeNode node, List<Integer> list, List<String> result) {
        list.add(node.val);
    
        if (node.left == null && node.right == null) result.add(handleList(list));
        if (node.left != null) handleNode(node.left, list, result);
        if (node.right != null) handleNode(node.right, list, result);
        
        list.remove(list.size() - 1);
    }

    private String handleList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = list.size(); i < size - 1; i++) {
            sb.append(list.get(i)).append("->");
        }
        sb.append(list.get(list.size() - 1));

        return sb.toString();
    }
}