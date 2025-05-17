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
class BSTIterator {
    private TreeNode node;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        node = root;
        stack = new Stack<>();

        TreeNode curr = node;
        while (curr != null) {
            stack.add(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        pushLeft(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        if (node == null) return;

        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */