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
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> inorderMap = buildInorderMap(inorder);
        return helper(preorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode helper(int[] preorder, int inorderStart, int inorderEnd, Map<Integer, Integer> inorderMap) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int preorderValue = preorder[preorderIndex++];
        int inorderIndex = inorderMap.get(preorderValue);

        TreeNode root = new TreeNode(preorderValue);
        root.left = helper(preorder, inorderStart, inorderIndex - 1, inorderMap);
        root.right = helper(preorder, inorderIndex + 1, inorderEnd, inorderMap);

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