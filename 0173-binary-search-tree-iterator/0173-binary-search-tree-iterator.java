class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    
    public int next() {
        TreeNode next = stack.pop();
        pushLeft(next.right);
        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}
