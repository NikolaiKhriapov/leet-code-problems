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
        return helper(preorder, inorder, 0, 0, inorder.length - 1, makeInorderMap(inorder));
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || preStart >= preorder.length) {
            return null;
        }

        int rootVal = preorder[preStart];
        int inRootIndex = inorderMap.get(rootVal);

        TreeNode root = new TreeNode(
            rootVal,
            helper(preorder, inorder, preStart + 1, inStart, inRootIndex - 1, inorderMap),
            helper(preorder, inorder, preStart + inRootIndex -inStart + 1, inRootIndex + 1, inEnd, inorderMap)
        );

        return root;
    }

    private Map<Integer, Integer> makeInorderMap(int[] inorder){
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return inorderMap;
    }
}