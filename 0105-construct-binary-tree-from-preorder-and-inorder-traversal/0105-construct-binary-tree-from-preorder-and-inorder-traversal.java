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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd || preStart >= preorder.length) return null;

        int rootVal = preorder[preStart];

        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(
            rootVal,
            helper(preorder, inorder, preStart + 1, inStart, inRootIndex - 1),
            helper(preorder, inorder, preStart + inRootIndex -inStart + 1, inRootIndex + 1, inEnd)
        );

        return root;
    }
}