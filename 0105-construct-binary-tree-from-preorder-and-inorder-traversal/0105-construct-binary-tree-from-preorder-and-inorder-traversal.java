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
        if (preorder.length != inorder.length || inorder.length == 0) {
            return null;
        }
        
        Map<Integer, Integer> inorderMap = buildInorderMap(inorder);
        return helper(preorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode helper(int[] preorder, int inorderLeft, int inorderRight, Map<Integer, Integer> inorderMap) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        int preorderValue = preorder[preorderIndex++];
        int inorderIndex = inorderMap.get(preorderValue);

        TreeNode root = new TreeNode(preorderValue);
        root.left = helper(preorder, inorderLeft, inorderIndex - 1, inorderMap);
        root.right = helper(preorder, inorderIndex + 1, inorderRight, inorderMap);
        
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