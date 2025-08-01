/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL_CHAR = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.add(node);
        }
        return deserialize(queue);
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_CHAR).append(",");
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals(NULL_CHAR)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));