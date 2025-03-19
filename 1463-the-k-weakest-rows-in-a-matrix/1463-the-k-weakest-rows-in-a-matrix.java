class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr = new int[mat.length][1];

        for (int i = 0; i < mat.length; i++) {
            int countSoldiers = countSoldiers(mat[i], 0, mat[i].length - 1);
            arr[i] = new int[] {i, countSoldiers};
        }
        
        Arrays.sort(arr, (a, b) -> (a[1] - b[1] != 0) ? (a[1] - b[1]) : (a[0] - b[0]));

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i][0];
        }

        return result;
    }

    private int countSoldiers(int[] arr, int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (arr[m] == 1) return countSoldiers(arr, m + 1, r);
        return countSoldiers(arr, l, m - 1);
    }
}