class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
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
        int counter = 0;
        for (int n : row) {
            if (n == 1) counter++;
            else break;
        }
        return counter;
    }
}