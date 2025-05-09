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
        if (inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inorderMap = buildInorderMap(inorder);
        return helper(postorder, 0, inorder.length - 1, inorderMap, new int[] {postorder.length - 1});
    }

    private TreeNode helper(int[] postorder, int inorderLeft, int inorderRight, Map<Integer, Integer> inorderMap, int[] postorderIndex) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        int value = postorder[postorderIndex[0]--];
        int inorderIndex = inorderMap.get(value);
        
        TreeNode root = new TreeNode(value);
        root.right = helper(postorder, inorderIndex + 1, inorderRight, inorderMap, postorderIndex);
        root.left = helper(postorder, inorderLeft, inorderIndex - 1, inorderMap, postorderIndex);
        
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