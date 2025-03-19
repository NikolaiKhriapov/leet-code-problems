class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr = new int[mat.length][1];

        for (int i = 0; i < mat.length; i++) {
            int countSoldiers = countSoldiers(mat[i]);
            arr[i] = new int[] {i, countSoldiers};
        }
        
        Arrays.sort(arr, (a, b) -> {
            int diff = a[1] - b[1];
            if (diff != 0) return diff;
            return a[0] - b[0];
        });

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i][0];
        }

        return result;
    }

    private int countSoldiers(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n == 1) count++;
            else break;
        }
        return count;
    }
}