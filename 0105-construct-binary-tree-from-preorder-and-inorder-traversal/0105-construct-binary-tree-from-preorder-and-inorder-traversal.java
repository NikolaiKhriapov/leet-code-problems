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
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> inorderMap = buildInorderMap(inorder);
        return buildSubtree(preorder, 0, inorder.length - 1, inorderMap, new int[]{0});
    }

    private TreeNode buildSubtree(int[] preorder, int inorderStart, int inorderEnd, Map<Integer, Integer> inorderMap, int[] preorderIndex) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int value = preorder[preorderIndex[0]++];
        int inorderIndex = inorderMap.get(value);

        TreeNode root = new TreeNode(value);
        root.left = buildSubtree(preorder, inorderStart, inorderIndex - 1, inorderMap, preorderIndex);
        root.right = buildSubtree(preorder, inorderIndex + 1, inorderEnd, inorderMap, preorderIndex);

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