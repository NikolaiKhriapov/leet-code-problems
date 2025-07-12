class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() > -asteroid) {
                    isDestroyed = true;
                    break;
                } else if (stack.peek() < -asteroid) {
                    stack.pop();
                } else {
                    stack.pop();
                    isDestroyed = true;
                    break;
                }
            }
            if (!isDestroyed) {
                stack.add(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        int idx = 0;
        for (int asteroid : stack) {
            result[idx++] = asteroid;
        }

        return result;
    }
}