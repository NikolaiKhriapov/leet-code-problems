class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }

        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");

        for (String dir : dirs) {
            if (Objects.equals(dir, "..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.isEmpty() && !Objects.equals(dir, ".")) {
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