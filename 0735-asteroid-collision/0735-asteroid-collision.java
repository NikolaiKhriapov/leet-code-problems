class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean isDestroyed = false;
            while (!deque.isEmpty() && deque.peekLast() > 0 && asteroids[i] < 0) {
                if (deque.peekLast() > -asteroids[i]) {
                    isDestroyed = true;
                    break;
                } else if (deque.peekLast() < -asteroids[i]) {
                    deque.pollLast();
                } else {
                    deque.pollLast();
                    isDestroyed = true;
                    break;
                }
            }
            if (!isDestroyed) {
                deque.offerLast(asteroids[i]);
            }
        }
        
        int[] result = new int[deque.size()];
        int idx = 0;
        while (!deque.isEmpty()) {
            result[idx++] = deque.pollFirst();
        }

        return result;
    }
}