class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        Map<Integer, Integer> inorderMap = buildInorderMap(inorder);
        return buildSubtree(postorder, inorderMap, 0, inorder.length - 1, new int[] {postorder.length - 1});
    }

    private TreeNode buildSubtree(int[] postorder, Map<Integer, Integer> inorderMap, int inorderLeft, int inorderRight, int[] postorderIndex) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        int value = postorder[postorderIndex[0]--];
        int inorderIndex = inorderMap.get(value);

        TreeNode node = new TreeNode(value);
        node.right = buildSubtree(postorder, inorderMap, inorderIndex + 1, inorderRight, postorderIndex);
        node.left = buildSubtree(postorder, inorderMap, inorderLeft, inorderIndex - 1, postorderIndex);

        return node;
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