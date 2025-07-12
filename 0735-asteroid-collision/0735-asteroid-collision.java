class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> deque = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (deque.isEmpty() || asteroid > 0) {
                deque.addLast(asteroid);
            } else {
                while (!deque.isEmpty() && deque.peekLast() > 0 && deque.peekLast() <= Math.abs(asteroid)) {
                    if (deque.peekLast() == Math.abs(asteroid)) {
                        asteroid = 0;
                    }
                    deque.pollLast();
                }
                if ((deque.isEmpty() || deque.peekLast() < 0) && asteroid != 0) {
                    deque.addLast(asteroid);
                }
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