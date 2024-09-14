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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> listP = new ArrayList<>();
        List<Integer> listQ = new ArrayList<>();

        handleNode(p, listP);
        handleNode(q, listQ);

        return Objects.equals(listP, listQ);
    }

    public void handleNode(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            if (node.left != null) {
                handleNode(node.left, list);
            }
            if (node.right != null) {
                handleNode(node.right, list);
            } else {
                list.add(null);
            }
        }
    }
}