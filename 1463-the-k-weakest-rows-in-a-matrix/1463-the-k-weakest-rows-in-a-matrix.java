class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            list.add(new int[]{ i, calcSoldiers(mat[i], 0, mat[i].length - 1) });
        }
        
        Collections.sort(list, (a, b) -> {
            if (a[1] >= b[1]) return 1;
            else return -1;
        });

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = list.get(i)[0];
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