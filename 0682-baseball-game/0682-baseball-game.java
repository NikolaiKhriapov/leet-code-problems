class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (Objects.equals(op, "C")) {
                stack.pop();
            } else if (Objects.equals(op, "D")) {
                stack.add(2 * stack.peek());
            } else if (Objects.equals(op, "+")) {
                Integer temp = stack.pop();
                Integer next = temp + stack.peek();
                stack.add(temp);
                stack.add(next);
            } else {
                stack.add(Integer.valueOf(op));
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}