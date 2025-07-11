class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.add(i);
        }
        
        return maxArea;
    }
}