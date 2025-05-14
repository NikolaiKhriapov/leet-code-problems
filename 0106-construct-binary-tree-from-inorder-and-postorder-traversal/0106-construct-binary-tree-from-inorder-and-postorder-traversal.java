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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        Map<Integer, Integer> inorderMap = buildInorderMap(inorder);
        return helper(postorder, 0, inorder.length - 1, inorderMap, new int[] {postorder.length - 1});
    }

    private TreeNode helper(int[] postorder, int inorderStart, int inorderEnd, Map<Integer, Integer> inorderMap, int[] postorderIndex) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int postorderValue = postorder[postorderIndex[0]--];
        int inorderIndex = inorderMap.get(postorderValue);

        TreeNode root = new TreeNode(postorderValue);
        root.right = helper(postorder, inorderIndex + 1, inorderEnd, inorderMap, postorderIndex);
        root.left = helper(postorder, inorderStart, inorderIndex - 1, inorderMap, postorderIndex);

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