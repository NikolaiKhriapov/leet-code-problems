class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessOrEqual(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else {
                count += row + 1;
                col++;
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