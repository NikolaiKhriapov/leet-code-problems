class Solution {
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(1);
        visited.add(1);

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == board.length * board.length) return count;
                for (int i = 1; i <= 6 && curr + i <= board.length * board.length; i++) {
                    int next = curr + i;
                    int[] nextCoord = getCoordinates(next, board.length);
                    int value = board[nextCoord[0]][nextCoord[1]];
                    if (value != -1) next = value;
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
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