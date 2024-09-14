class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root);
            root = root.right;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i + 1);
        }
        TreeNode last = list.get(list.size() - 1);
        last.left = null;
        last.right = null;

        return list.get(0);
    }
}

// class Solution {
//     public TreeNode increasingBST(TreeNode root) {
        
//         List<TreeNode> list = new ArrayList<>();

//         handleNode(root, list);

//         for (int i = 0; i < list.size() - 1; i++) {
//             TreeNode node = list.get(i);
//             node.left = null;
//             node.right = list.get(i + 1);
//         }
//         TreeNode last = list.get(list.size() - 1);
//         last.left = null;
//         last.right = null;

//         return list.get(0);
//     }

//     public void handleNode(TreeNode root, List<TreeNode> list) {
//         if (root.left != null) handleNode(root.left, list);
//         list.add(root);
//         if (root.right != null) handleNode(root.right, list);
//     }
// }