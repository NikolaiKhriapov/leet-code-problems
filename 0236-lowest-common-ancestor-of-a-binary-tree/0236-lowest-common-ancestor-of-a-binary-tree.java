/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        boolean isLeft = Objects.equals(left, p) || Objects.equals(left, q);
        boolean isRight = Objects.equals(right, p) || Objects.equals(right, q);
        boolean isCurr = Objects.equals(root, p) || Objects.equals(root, q);
        
        if (left != null && !isLeft) return left;
        if (right != null && !isRight) return right;
        if ((isLeft && isRight) || (isCurr && isLeft) || (isCurr && isRight)) return root;
        if (isLeft) return left;
        if (isRight) return right;
        if (isCurr) return root;

        return null;
    }
}
