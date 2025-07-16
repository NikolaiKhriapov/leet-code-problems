class Solution {
    private static final char EMPTY = '.';
    private static final char WALL = '+';
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (!isWithinBounds(maze, entrance[0], entrance[1])) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[maze.length * maze[0].length];
        queue.add(entrance);
        visited[generateKey(entrance[0], entrance[1], maze[0].length)] = true;

        int counter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                if (isExit(maze, entrance, curr)) {
                    return counter;
                }
                for (int[] neighbor : NEIGHBORS) {
                    int r = curr[0] + neighbor[0];
                    int c = curr[1] + neighbor[1];
                    if (
                        isWithinBounds(maze, r, c)
                        && maze[r][c] == EMPTY
                        && !visited[generateKey(r, c, maze[0].length)]
                    ) {
                        queue.add(new int[] {r, c});
                        visited[generateKey(r, c, maze[0].length)] = true;
                    }
                }
            }
            counter++;
        }
        
        return -1;
    }

    private int generateKey(int row, int col, int cols) {
        return row * cols + col;
    }

    private boolean isWithinBounds(char[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length;
    }

    private boolean isExit(char[][] maze, int[] entrance, int[] cell) {
        return !Arrays.equals(entrance, cell) && 
               (cell[0] == 0 || cell[0] == maze.length - 1 || cell[1] == 0 || cell[1] == maze[0].length - 1);
    }
}