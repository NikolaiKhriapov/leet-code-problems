class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (asteroids.length <= 1) {
            return asteroids;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && stack.peekLast() > 0 && asteroid < 0) {
                if (stack.peekLast() > -asteroid) {
                    isDestroyed = true;
                    break;
                } else if (stack.peekLast() < -asteroid) {
                    stack.pollLast();
                } else {
                    stack.pollLast();
                    isDestroyed = true;
                    break;
                }
            }
            if (!isDestroyed) {
                stack.offerLast(asteroid);
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