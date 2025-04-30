class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 1) {
            return -1;
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                pq.add(matrix[r][c]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}

// [
//  [ 1, 5, 9],
//  [10,11,13],
//  [12,13,15]
// ]
