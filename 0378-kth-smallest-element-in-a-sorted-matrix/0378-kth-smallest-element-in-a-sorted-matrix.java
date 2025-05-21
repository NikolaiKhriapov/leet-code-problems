class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int l = matrix[0][0];
        int r = matrix[matrix.length - 1][matrix[0].length - 1];
        while (l < r) {
            int m = l + (r - l) / 2;
            int count = countLessOrEqual(matrix, m);
            if (count < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int count = 0;
        
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}

// [ 1, 2, 3, 4, 5]
// [ 6, 7, 8, 9,10]
// [11,12,13,14,15]
// [16,17,18,19,20]
// [21,22,23,24,25]
