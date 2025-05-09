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
    private int postorderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        postorderIndex = postorder.length - 1;
        Map<Integer, Integer> inorderMap = buildInorderMap(inorder);
        return helper(postorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode helper(int[] postorder, int inLeft, int inRight, Map<Integer, Integer> inorderMap) {
        if (inLeft > inRight) return null;

        int postorderValue = postorder[postorderIndex--];
        int inorderIndex = inorderMap.get(postorderValue);

        TreeNode root = new TreeNode(postorderValue);
        root.right = helper(postorder, inorderIndex + 1, inRight, inorderMap);
        root.left = helper(postorder, inLeft, inorderIndex - 1, inorderMap);

        return root;
    }

    private Map<Integer, Integer> buildInorderMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }
}