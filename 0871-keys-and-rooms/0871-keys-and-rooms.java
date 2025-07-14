class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[rooms.size()];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currRoom = queue.pollFirst();
            for (int key : rooms.get(currRoom)) {
                if (!visited[key]) {
                    queue.offerLast(key);
                    visited[key] = true;
                }
            }
        }
        
        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }
        return true;
    }
}