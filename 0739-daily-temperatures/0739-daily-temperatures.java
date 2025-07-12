class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIdx = stack.pop();
                result[prevIdx] = i - prevIdx;
            }
            stack.add(i);
        }
        
        return result;
    }
}