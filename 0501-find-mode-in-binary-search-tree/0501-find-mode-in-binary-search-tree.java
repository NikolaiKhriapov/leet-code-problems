class Solution {

    private Integer prev = null;
    private int count = 0;
    private int countMax = 0;
    private List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        helper(root);
        return convertListToArray(list);
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            helper(node.left);
        }

        if (prev != null && node.val == prev) {
            count++;
        } else {
            count = 1;
        }

        if (count > countMax) {
            countMax = count;
            list = new ArrayList<>();
            list.add(node.val);
        } else if (count == countMax) {
            list.add(node.val);
        }

        prev = node.val;

        if (node.right != null) {
            helper(node.right);
        }
    }

    private int[] convertListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}