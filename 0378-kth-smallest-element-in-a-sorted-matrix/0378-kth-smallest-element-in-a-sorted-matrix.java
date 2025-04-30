class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 1 || k > matrix.length * matrix[0].length) {
            return -1;
        }
        
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countLessOrEqual(matrix, mid);
            if (count < k) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        int count = 0;
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