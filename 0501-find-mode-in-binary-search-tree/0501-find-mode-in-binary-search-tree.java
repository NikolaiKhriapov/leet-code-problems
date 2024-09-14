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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        handleNode(root, map);

        List<Integer> list = new ArrayList<>();
        int largest = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > largest) {
                largest = entry.getValue();
            }
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() == largest) {
                list.add(entry.getKey());
            }
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    private void handleNode(TreeNode node, HashMap<Integer, Integer> map) {
        if (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            if (node.left != null) {
                handleNode(node.left, map);
            }
            if (node.right != null) {
                handleNode(node.right, map);
            }
        }
    }
}