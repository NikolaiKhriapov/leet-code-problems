class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> 
            (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) - 
            (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter))
        );

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                pq.add(new int[] {r, c});
            }
        }

        int[][] result = new int[rows * cols][2];
        for (int i = 0; i < rows * cols; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}