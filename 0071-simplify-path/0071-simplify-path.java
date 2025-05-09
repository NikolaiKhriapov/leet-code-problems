class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        String[] dirs = path.split("/");

        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.add(dir);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        if (result.isEmpty()) {
            result.append("/");
        }
        
        return result.toString();
    }
}