class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < mat.length; i++) {
            queue.offer(new int[]{ i, calcSoldiers(mat[i], 0, mat[i].length - 1) });
        }
        
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = queue.poll()[0];
        }

        return arr;
    }

    private int calcSoldiers(int[] row, int l, int r) {
        if (r < l) return r;

        int m = l + (r - l) / 2;
        if (row[m] == 0) return calcSoldiers(row, l, m - 1);
        else return calcSoldiers(row, m + 1, r);
    }
}