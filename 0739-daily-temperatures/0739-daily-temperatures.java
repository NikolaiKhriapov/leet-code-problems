class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                temperatures[prevIndex] = i - prevIndex;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            temperatures[stack.pop()] = 0;
        }
        return temperatures;
    }
}