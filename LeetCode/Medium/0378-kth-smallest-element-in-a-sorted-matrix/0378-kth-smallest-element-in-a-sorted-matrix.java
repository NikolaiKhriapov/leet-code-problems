class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 1 || k > matrix.length * matrix[0].length) {
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
        int row = matrix.length - 1;
        int col = 0;
        int count = 0;
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

// time  - O(log(m*n) * (m + n))
// space - O(1)