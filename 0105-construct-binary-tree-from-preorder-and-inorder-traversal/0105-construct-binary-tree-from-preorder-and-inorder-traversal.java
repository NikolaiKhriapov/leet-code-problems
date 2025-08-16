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
        return buildSubtree(preorder, inorderMap, 0, inorder.length - 1, new int[] {0});
    }

    private TreeNode buildSubtree(int[] preorder, Map<Integer, Integer> inorderMap, int inorderLeft, int inorderRight, int[] preorderIndex) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        int value = preorder[preorderIndex[0]++];
        int inorderIndex = inorderMap.get(value);

        return new TreeNode(
            value,
            buildSubtree(preorder, inorderMap, inorderLeft, inorderIndex - 1, preorderIndex),
            buildSubtree(preorder, inorderMap, inorderIndex + 1, inorderRight, preorderIndex)
        );
    }

    private Map<Integer, Integer> buildInorderMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

}

// time  - O(n)
// space - O(n)