class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]>[] arrList = new List[rows + cols];
        for (int i = 0; i < arrList.length; i++) {
            arrList[i] = new ArrayList<>();
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                arrList[dist].add(new int[] {r, c});
            }
        }

        int[][] result = new int[rows * cols][2];
        int idx = 0;
        for (List<int[]> list : arrList) {
            for (int[] el : list) {
                result[idx++] = el;
            }
        }

        return result;
    }
}