class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                int prevIdx = stack.pollLast();
                result[prevIdx] = i - prevIdx;
            }
            stack.offerLast(i);
        }
        
        return result;
    }
}