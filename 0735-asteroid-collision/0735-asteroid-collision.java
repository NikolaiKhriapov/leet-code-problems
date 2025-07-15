class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean isDestroyed = false;
            while (!deque.isEmpty() && asteroid < 0 && deque.peekLast() > 0) {
                if (deque.peekLast() > -asteroid) {
                    isDestroyed = true;
                    break;
                } else if (deque.peekLast() < -asteroid) {
                    deque.pollLast();
                } else {
                    deque.pollLast();
                    isDestroyed = true;
                    break;
                }
            }
            if (!isDestroyed) {
                deque.offerLast(asteroid);
            }
        }
        
        int[] result = new int[deque.size()];
        int idx = 0;
        for (int asteroid : deque) {
            result[idx++] = asteroid;
        }

        return result;
    }
}