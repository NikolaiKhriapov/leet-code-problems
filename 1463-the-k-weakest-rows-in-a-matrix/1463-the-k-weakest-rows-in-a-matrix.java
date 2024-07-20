class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            list.add(new Integer[]{ i, calcSoldiers(mat[i]) });
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

    private int calcSoldiers(int[] row) {
        int count = 0;
        for (int n : row) {
            if (n == 1) count++;
            else return count;
        }
        return count;
    }
}