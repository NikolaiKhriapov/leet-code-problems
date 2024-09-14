class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int soldiers = calcSoldiers(mat[i], 0, mat[i].length);
            queue.add(new int[] { soldiers, i });
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[1];
        }

        return result;
    }

    private int calcSoldiers(int[] row, int l, int r) {
        if (l > r) {
            return r;
        }
        
        int m = l + (r - l) / 2;

        if ((row[m] == 1 && m == row.length - 1) || (row[m] == 1 && row[m + 1] == 0)) {
            return m + 1;
        } else if (row[m] == 1) {
            return calcSoldiers(row, m + 1, r);
        } else {
            return calcSoldiers(row, l, m - 1);
        }
    }
}