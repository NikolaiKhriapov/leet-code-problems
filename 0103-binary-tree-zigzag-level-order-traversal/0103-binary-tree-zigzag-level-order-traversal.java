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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            List<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                nodes.add(q.poll());
            }

            if (leftToRight) {
                for (int i = 0; i < nodes.size(); i++) {
                    TreeNode node = nodes.get(i);
                    list.add(node.val);
                }
            } else {
                for (int i = nodes.size() - 1; i >= 0; i--) {
                    TreeNode node = nodes.get(i);
                    list.add(node.val);
                }
            }

            for (TreeNode node : nodes) {
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            leftToRight = !leftToRight;
            result.add(list);
        }

        return result;
    }
}
