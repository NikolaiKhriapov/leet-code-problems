class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int x = a[1] - b[1];
            if (x == 0) return a[0] - b[0];
            return x;
        });

        for (int i = 0; i < mat.length; i++) {
            pq.add(new int[] {i, helper(mat[i], 0, mat[i].length - 1)});
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }

    private int helper(int[] row, int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (row[m] == 1) return helper(row, m + 1, r);
        if (row[m] == 0 && (m == 0 || row[m - 1] == 1)) return m;
        return helper(row, l, m - 1);
    }
}