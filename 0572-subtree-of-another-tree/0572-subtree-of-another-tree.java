class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (isSubroot(curr, subRoot)) return true;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return false;
    }

    private boolean isSubroot(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) return true;
        if (node == null || subRoot == null) return false;

        return node.val == subRoot.val && isSubroot(node.left, subRoot.left) && isSubroot(node.right, subRoot.right);
    }
}