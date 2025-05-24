class Solution {
    public int snakesAndLadders(int[][] board) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[board.length * board.length + 1];

        q.add(1);
        visited[1] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == board.length * board.length) return count;
                for (int i = 1; i <= 6 && curr + i <= board.length * board.length; i++) {
                    int next = curr + i;
                    int[] nextCoord = getCoordinates(next, board.length);
                    int val = board[nextCoord[0]][nextCoord[1]];
                    if (val != -1) next = val;
                    if (!visited[next]) {
                        q.add(next);
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