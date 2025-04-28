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
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inorderMap = createInorderMap(inorder);
        return helper(preorder, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd) {
            return null;
        }

        int val = preorder[preorderIndex++];
        int inorderIndex = inorderMap.get(val);
        return new TreeNode(
            val,
            helper(preorder, inorder, inStart, inorderIndex - 1, inorderMap),
            helper(preorder, inorder, inorderIndex + 1, inEnd, inorderMap)
        );
    }

    private Map<Integer, Integer> createInorderMap(int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return inorderMap;
    }
}