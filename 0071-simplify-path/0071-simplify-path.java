class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        
        String[] dirs = path.split("/");

        for (String dir : dirs) {
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollFirst();
                }
            } else {
                deque.offerFirst(dir);
            }
        }

        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollLast());
        }
        if (sb.isEmpty()) {
            sb.append("/");
        }

        return sb.toString();
    }
}

// time  - O(n)
// space - O(n)