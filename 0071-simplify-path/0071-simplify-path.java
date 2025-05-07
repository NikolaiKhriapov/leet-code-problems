class Solution {
    public String simplifyPath(String path) {

        // init stack
        Stack<String> stack = new Stack<>();

        // split path by `/`
        String[] parts = path.split("/");

        // for-each 
            // if (..) pop() else if (.) continue else add
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
        Collections.reverse(stack);

        // for each append to stringbuilder
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pop());
        }
        if (result.isEmpty()) {
            result.append("/");
        }

        return result.toString();
    }
}