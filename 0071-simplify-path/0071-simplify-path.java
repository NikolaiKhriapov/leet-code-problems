class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || Objects.equals(part, ".")) {
                continue;
            }
            if (Objects.equals(part, "..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(part);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String el : stack) {
            result.append("/").append(el);
        }
        if (result.isEmpty()) {
            result.append("/");
        }

        return result.toString();
    }
}