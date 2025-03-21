class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]>[] listArr = new List[rows + cols];
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int[] cell = new int[] {r, c};
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                listArr[dist].add(cell);
            }
        }

        int[][] result = new int[rows * cols][2];
        int count = 0;
        for (List<int[]> list : listArr) {
            for (int[] el : list) {
                result[count++] = el;
            }
        }

        return result;
    }
}