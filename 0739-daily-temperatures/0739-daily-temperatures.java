class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                temperatures[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            temperatures[stack.pop()] = 0;
        }
        return temperatures;
    }
}