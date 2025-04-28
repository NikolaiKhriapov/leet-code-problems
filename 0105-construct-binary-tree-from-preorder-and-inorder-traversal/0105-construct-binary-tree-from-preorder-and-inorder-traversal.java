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

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || preStart >= preorder.length) return null;

        int val = preorder[preStart];
        int inorderIndex = inorderMap.get(val);
        
        return new TreeNode(
            val,
            helper(preorder, inorder, preStart + 1, inStart, inorderIndex - 1, inorderMap),
            helper(preorder, inorder, preStart + inorderIndex - inStart + 1, inorderIndex + 1, inEnd, inorderMap)
        );
    }
}