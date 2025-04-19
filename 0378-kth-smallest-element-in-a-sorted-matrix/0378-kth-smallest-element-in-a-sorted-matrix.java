class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.add(new int[] {matrix[0][0], 0, 0});
        boolean[][] visited = new boolean[n][n];

        while (--k > 0) {
            int[] curr = minHeap.poll();
            int val = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row + 1 < n && !visited[row + 1][col]) {
                minHeap.add(new int[] {matrix[row + 1][col], row + 1, col});
                visited[row + 1][col] = true;
            }
            if (col + 1 < n && !visited[row][col + 1]) {
                minHeap.add(new int[] {matrix[row][col + 1], row, col + 1});
                visited[row][col + 1] = true;
            }
        }
        
        return minHeap.poll()[0];
    }
}
