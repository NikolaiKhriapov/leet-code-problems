class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
    }
}