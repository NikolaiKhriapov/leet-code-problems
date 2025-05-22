class Solution {
    public int snakesAndLadders(int[][] board) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[board.length * board.length + 1];

        queue.add(1);
        visited[1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == board.length * board.length) return count;

                for (int i = 1; i <= 6 && curr + i <= board.length * board.length; i++) {
                    int next = curr + i;
                    int[] nextCoord = getCoordinates(next, board.length);
                    int value = board[nextCoord[0]][nextCoord[1]];
                    if (value != -1) next = value;

                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            count++;
        }
        
        return -1;
    }

    private int[] getCoordinates(int num, int size) {
        int row = (size - 1) - (num - 1) / size;
        int col = (num - 1) % size;
        if ((size - row) % 2 == 0) col = size - 1 - col;
        return new int[]{row, col};
    }
}